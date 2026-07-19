package io.github.tdlibx.tdlib.gradle.internal

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.file.DirectoryProperty

import org.gradle.api.provider.Property
import java.util.zip.ZipFile
import java.io.File

abstract class TdlibXcframeworkUnpackTask : DefaultTask() {
    @get:Input
    abstract val configurationName: Property<String>


    @get:OutputDirectory
    abstract val outputDirectory: DirectoryProperty

    init {
        // Always run this task since it cleans the output directory at the start
        outputs.upToDateWhen { false }
    }

    @TaskAction
    fun unpack() {
        val outputDir = outputDirectory.get().asFile
        if (outputDir.exists()) {
            outputDir.deleteRecursively()
        }
        outputDir.mkdirs()

        // Unzip the xcframework
        // Resolve the xcframework zip from the configuration
        val config = project.configurations.getByName(configurationName.get())
        val xcframeworkZip = config.resolve().firstOrNull { it.name.endsWith(".zip") }
            ?: throw IllegalStateException("No xcframework zip found in configuration ${configurationName.get()}")
        ZipFile(xcframeworkZip).use { zip ->
            zip.entries().toList().forEach { entry ->
                if (!entry.isDirectory) {
                    val outFile = File(outputDir, entry.name)
                    outFile.parentFile?.mkdirs()
                    zip.getInputStream(entry).use { input ->
                        outFile.outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                }
            }
        }

        logger.lifecycle("Unpacked xcframework to $outputDir")
    }
}