import com.vanniktech.maven.publish.GradlePlugin
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    kotlin("jvm")
    `maven-publish`
    `java-gradle-plugin`
    signing
    id("com.vanniktech.maven.publish")
}

group = "io.github.tdlibx"
version = "1.8.56-RC10"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(gradleApi())
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.21")
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    testImplementation("org.gradle:gradle-test-kit")
}

gradlePlugin {
    plugins {
        create("tdlibXcframework") {
            id = "io.github.tdlibx.tdlib-xcframework"
            implementationClass = "io.github.tdlibx.tdlib.gradle.TdlibXcframeworkPlugin"
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

mavenPublishing {
    coordinates("io.github.tdlibx", "td-gradle-plugin", version.toString())

    pom {
        name.set("td-gradle-plugin")
        description.set("Gradle plugin for automatic TDLib xcframework resolution and linking")
        inceptionYear.set("2026")
        url.set("https://github.com/tdlibx/td-ktx")
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
            url.set("https://github.com/tdlibx/td-ktx")
            connection.set("scm:git:git://github.com/tdlibx/td-ktx.git")
            developerConnection.set("scm:git:ssh://git@github.com/tdlibx/td-ktx.git")
        }
    }

    publishToMavenCentral()

    configure(
        GradlePlugin(
            javadocJar = JavadocJar.Empty(),
            sourcesJar = SourcesJar.Sources(),
        ),
    )

    signAllPublications()
}
