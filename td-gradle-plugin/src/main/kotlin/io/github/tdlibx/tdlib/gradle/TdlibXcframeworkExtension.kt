package io.github.tdlibx.tdlib.gradle

import org.gradle.api.Project
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property

abstract class TdlibXcframeworkExtension(private val project: Project) {
    abstract val version: Property<String>
    abstract val includeTargets: ListProperty<String>

    init {
        // Resolution order:
        //   1. Explicit `version.set(...)` value the consumer provides.
        //   2. Project extra property `tdlibx.tdlibJsonVersion` — the bootstrap settings
        //      plugin sets this so consumers don't need to repeat it.
        //   3. Gradle property `tdlibx.tdlibJsonVersion`.
        //   4. The project's own version (carry-over from pre-bootstrap builds).
        val extraFallback = project.provider {
            // extraProperties.has("tdlibx.tdlibJsonVersion") so we don't throw
            // "does not exist" when the property was never set by the bootstrap plugin.
            if (project.extensions.extraProperties.has("tdlibx.tdlibJsonVersion")) {
                project.extensions.extraProperties["tdlibx.tdlibJsonVersion"] as String?
            } else null
        }
        version.convention(
            extraFallback
                .orElse(project.providers.gradleProperty("tdlibx.tdlibJsonVersion"))
                .orElse(project.provider { project.version.toString() })
        )
        includeTargets.convention(emptyList())
    }
}
