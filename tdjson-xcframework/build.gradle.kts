import org.gradle.api.publish.maven.MavenPublication

plugins {
    id("com.vanniktech.maven.publish")
    id("signing")
}

group = "io.github.tdlibx"
version = "1.8.56-RC10"

val xcframeworkSourceDir = project.rootDir.resolve("iosApp/libtdjson.xcframework")
val outputDir = project.layout.buildDirectory.dir("xcframework-work/libtdjson.xcframework")
val zipFile = project.layout.buildDirectory.file("td-libtdjson-${version}.zip")

tasks.register<Zip>("xcframeworkZip") {
    group = "packaging"
    description = "Creates trimmed xcframework zip for Maven publication"
    destinationDirectory.set(project.layout.buildDirectory)
    archiveFileName.set("td-libtdjson-${version}.zip")
    from(outputDir)
}

tasks.register("prepareXcframework") {
    group = "packaging"
    description = "Prepares trimmed xcframework from source"
    doLast {
        val slicesToInclude = mapOf(
            "ios-arm64" to listOf("arm64"),
            "ios-arm64_x86_64-simulator" to listOf("arm64", "x86_64"),
            "macos-arm64_x86_64" to listOf("arm64", "x86_64")
        )

        outputDir.get().asFile.mkdirs()

        slicesToInclude.forEach { (sliceName, _) ->
            val srcSlice = xcframeworkSourceDir.resolve(sliceName)
            val destSlice = outputDir.get().asFile.resolve(sliceName)
            if (srcSlice.exists()) {
                destSlice.mkdirs()
                srcSlice.resolve("libtdjson.dylib").copyTo(destSlice.resolve("libtdjson.dylib"))
            }
        }

        generateInfoPlist(outputDir.get().asFile, slicesToInclude.keys.toList())
    }
    finalizedBy("xcframeworkZip")
}

fun generateInfoPlist(xcframeworkDir: java.io.File, sliceNames: List<String>) {
    val sb = StringBuilder()
    sb.appendLine("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
    sb.appendLine("<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">")
    sb.appendLine("<plist version=\"1.0\">")
    sb.appendLine("<dict>")
    sb.appendLine("    <key>AvailableLibraries</key>")
    sb.appendLine("    <array>")

    sliceNames.forEach { sliceName ->
        val arches = when (sliceName) {
            "ios-arm64" -> listOf("arm64")
            "ios-arm64_x86_64-simulator" -> listOf("arm64", "x86_64")
            "macos-arm64_x86_64" -> listOf("arm64", "x86_64")
            else -> listOf("arm64")
        }
        val platform = when {
            sliceName.startsWith("ios-") && sliceName.contains("simulator") -> "com.apple.platform.iphonesimulator"
            sliceName.startsWith("ios-") -> "com.apple.platform.iphoneos"
            else -> "com.apple.platform.macosx"
        }

        sb.appendLine("        <dict>")
        sb.appendLine("            <key>BinaryPath</key>")
        sb.appendLine("            <string>libtdjson.dylib</string>")
        sb.appendLine("            <key>LibraryIdentifier</key>")
        sb.appendLine("            <string>$sliceName</string>")
        sb.appendLine("            <key>LibraryPath</key>")
        sb.appendLine("            <string>libtdjson.dylib</string>")
        sb.appendLine("            <key>SupportedArchitectures</key>")
        sb.appendLine("            <array>")
        arches.forEach { arch ->
            sb.appendLine("                <string>$arch</string>")
        }
        sb.appendLine("            </array>")
        sb.appendLine("            <key>SupportedPlatform</key>")
        sb.appendLine("            <string>$platform</string>")
        sb.appendLine("        </dict>")
    }

    sb.appendLine("    </array>")
    sb.appendLine("    <key>CFBundlePackageType</key>")
    sb.appendLine("    <string>FMWK</string>")
    sb.appendLine("    <key>XCFrameworkFormatVersion</key>")
    sb.appendLine("    <string>1.0</string>")
    sb.appendLine("</dict>")
    sb.appendLine("</plist>")

    xcframeworkDir.resolve("Info.plist").writeText(sb.toString())
}

tasks.named("publish") {
    dependsOn("prepareXcframework", "xcframeworkZip")
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "io.github.tdlibx"
            artifactId = "td-libtdjson"
            version = project.version.toString()

            artifact(tasks.named("xcframeworkZip").get()) {
                extension = "zip"
            }

            pom {
                name.set("TDLib JSON xcframework")
                description.set("Prebuilt TDLib JSON xcframework for Kotlin Multiplatform iOS/macOS targets")
                url.set("https://github.com/tdlibx/td")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("tdlibx")
                        name.set("tdlibx Contributors")
                    }
                }
                scm {
                    url.set("https://github.com/tdlibx/td")
                    connection.set("scm:git:git://github.com/tdlibx/td.git")
                    developerConnection.set("scm:git:ssh://git@github.com/tdlibx/td.git")
                }
            }
        }
    }
}

mavenPublishing {
    coordinates("io.github.tdlibx", "td-libtdjson", version.toString())

    pom {
        name.set("td-libtdjson")
        description.set("Prebuilt TDLib JSON xcframework for Kotlin Multiplatform iOS/macOS targets")
        inceptionYear.set("2026")
        url.set("https://github.com/tdlibx/td")
        licenses {
            license {
                name.set("The Apache Software License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("tdlibx")
                name.set("tdlibx Contributors")
            }
        }
        scm {
            url.set("https://github.com/tdlibx/td")
            connection.set("scm:git:git://github.com/tdlibx/td.git")
            developerConnection.set("scm:git:ssh://git@github.com/tdlibx/td.git")
        }
    }

    publishToMavenCentral()

    signAllPublications()
}