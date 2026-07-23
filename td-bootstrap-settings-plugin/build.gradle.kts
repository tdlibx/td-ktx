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
    implementation(kotlin("stdlib"))
}

gradlePlugin {
    plugins {
        create("tdlibxPlugin") {
            id = "io.github.tdlibx.plugin"
            implementationClass = "io.github.tdlibx.plugin.TdlibxBootstrapSettingsPlugin"
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

mavenPublishing {
    coordinates("io.github.tdlibx", "plugin", version.toString())

    pom {
        name.set("tdlibx Plugin")
        description.set("Single-line bootstrap for applying the full TDLib Kotlin bindings stack")
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
