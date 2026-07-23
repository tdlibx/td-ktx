package io.github.tdlibx.plugin

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

/**
 * Settings plugin that bootstraps a consumer project to use the TDLib Kotlin bindings.
 *
 * What this plugin does:
 *   - Adds `mavenCentral()`, `gradlePluginPortal()`, and `google()` to BOTH
 *     `pluginManagement.repositories` AND `dependencyResolutionManagement.repositories`.
 *   - Registers `io.github.tdlibx.tdlib-xcframework` with `pluginManagement.plugins` so the
 *     plugin id is discoverable from any consuming subproject's `plugins { id(...) }` block
 *     at the version declared in this settings plugin.
 *   - Sets `tdlibx.tdlibJsonVersion` as an `extraProperties` entry on every project (root +
 *     subprojects) at configuration time. The xcframework plugin reads this property (via
 *     `project.providers.gradleProperty` chained with `extraProperties`) to resolve
 *     `io.github.tdlibx:td-libtdjson:<version>` without each consuming module having to
 *     repeat `version = "..."` in its own build script.
 *
 * Consumer workflow (minimal):
 *
 *   // settings.gradle.kts
 *   plugins { id("io.github.tdlibx.plugin") version "1.8.56-RC10" }
 *
 *   // shared/build.gradle.kts
 *   plugins {
 *       kotlin("multiplatform")
 *       id("io.github.tdlibx.tdlib-xcframework")  // version declared above
 *   }
 *   kotlin { macosArm64() }
 *   dependencies {
 *       commonMain.implementation("io.github.tdlibx:td:1.8.56-RC10")
 *       commonMain.implementation("io.github.tdlibx:td-ktx:1.8.56-RC10")
 *   }
 */
class TdlibxBootstrapSettingsPlugin : Plugin<Settings> {
    override fun apply(target: Settings) {
        val version = readBootstrapVersion(target)

        target.pluginManagement.repositories.apply {
            mavenCentral()
            gradlePluginPortal()
            google()
        }
        target.pluginManagement.plugins.apply {
            id("io.github.tdlibx.tdlib-xcframework").version(version)
        }

        target.dependencyResolutionManagement.repositories.apply {
            mavenCentral()
            google()
        }

        // Propagate the version onto every project's extraProperties so the
        // xcframework project plugin can find it without each module having to repeat
        // it. We do this in `beforeProject` so the value is visible by the time the
        // xcframework extension is queried from `afterEvaluate`.
        target.gradle.beforeProject { project ->
            if (!project.extensions.extraProperties.has("tdlibx.tdlibJsonVersion")) {
                project.extensions.extraProperties["tdlibx.tdlibJsonVersion"] = version
            }
        }
    }

    private fun readBootstrapVersion(target: Settings): String {
        val provider = target.providers.gradleProperty("tdlibx.bootstrapVersion")
        val fromManifest =
            runCatching {
                this::class.java.`package`.implementationVersion
            }.getOrNull()
        return provider.orElse(target.providers.provider { fromManifest ?: "unspecified" }).get()
    }
}
