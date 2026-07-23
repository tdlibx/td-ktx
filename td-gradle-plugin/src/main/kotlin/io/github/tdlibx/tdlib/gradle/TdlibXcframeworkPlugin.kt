package io.github.tdlibx.tdlib.gradle

import io.github.tdlibx.tdlib.gradle.internal.TdlibXcframeworkUnpackTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

class TdlibXcframeworkPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        @Suppress("UNCHECKED_CAST")
        val ext =
            project.extensions.create(
                "tdlibXcframework",
                TdlibXcframeworkExtension::class.java,
                project,
            ) as TdlibXcframeworkExtension

        project.plugins.withId("org.jetbrains.kotlin.multiplatform") {
            project.afterEvaluate {
                configureMultiplatform(project, ext)
            }
        }
    }

    private fun configureMultiplatform(
        project: Project,
        ext: TdlibXcframeworkExtension,
    ) {
        val version = ext.version.get()
        val cfg = project.configurations.create("tdlibXcframeworkRuntime")
        cfg.isCanBeResolved = true
        cfg.isCanBeConsumed = false
        cfg.dependencies.add(project.dependencies.create("io.github.tdlibx:td-libtdjson:$version"))

        // Wire -L/-rpath/-ltdjson/-lz/-lc++ linker flags onto each Kotlin/Native binary.
        // We resolve the configuration lazily so consumers may declare `version` in
        // afterEvaluate (settings plugin path) without racing the plugin lifecycle.
        val nativeBinaries =
            project.extensions
                .findByType(KotlinMultiplatformExtension::class.java)
                ?.targets
                ?.filterIsInstance<KotlinNativeTarget>()
                .orEmpty()
        val includedTargets = ext.includeTargets.orElse(emptyList()).get()

        val unpackTaskProvider =
            project.tasks.register(
                "resolveTdlibXcframework",
                TdlibXcframeworkUnpackTask::class.java,
            )
        val unpackTask = unpackTaskProvider.get()
        unpackTask.configurationName.set("tdlibXcframeworkRuntime")
        unpackTask.outputDirectory.set(project.layout.buildDirectory.dir("tdlib-xcframework/unpacked"))
        // Force task to always run since it cleans output directory
        unpackTask.outputs.upToDateWhen { false }

        for (kt in nativeBinaries) {
            val targetName = kt.name
            val shouldInclude = includedTargets.isEmpty() || includedTargets.any { it == targetName }
            if (!shouldInclude) continue

            for (binary in kt.binaries) {
                val libraryIdentifier =
                    when (kt.konanTarget.name) {
                        "ios_arm64" -> "ios-arm64"
                        "ios_x64", "ios_simulator_arm64" -> "ios-arm64_x86_64-simulator"
                        "macos_arm64", "macos_x64" -> "macos-arm64_x86_64"
                        else -> null
                    }
                if (libraryIdentifier == null) continue

                val dylibDir = project.layout.buildDirectory.dir("tdlib-xcframework/unpacked/$libraryIdentifier")

                binary.linkerOpts(
                    "-L${dylibDir.get().asFile.absolutePath}",
                    "-rpath",
                    dylibDir.get().asFile.absolutePath,
                    "-ltdjson",
                    "-lz",
                    "-lc++",
                )

                // Make every native link task depend on having the xcframework unpacked.
                // Without this wiring the linker is invoked before resolveTdlibXcframework
                // runs, so `-L<unpacked-dir>` points at a non-existent directory and `ld`
                // reports `library 'tdjson' not found`.
                val taskNameUpper = kt.name.replaceFirstChar { c -> c.uppercaseChar() }
                project.tasks
                    .matching {
                        it.name.startsWith("link") && it.name.contains(taskNameUpper)
                    }.configureEach { task ->
                        task.dependsOn(unpackTaskProvider)
                    }
            }
        }
    }
}
