plugins {
    kotlin("jvm") version "1.5.0"
    `maven-publish`
    signing
}

group = "de.hammwerk"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "ossrh"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                val ossrhUsername: String? by project
                val ossrhPassword: String? by project
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = "material-color-palette"
            version = project.version.toString()

            pom {
                packaging = "jar"
                name.set("Material Design Color Palette Generator")
                description.set("A reverse engineered library for generating a custom Material Design color palette.")
                url.set("https://github.com/Hammwerk/material-color-palette")

                scm {
                    connection.set("scm:git:git://github.com/Hammwerk/material-color-palette.git")
                    developerConnection.set("scm:git:ssh://github.com/Hammwerk/material-color-palette.git")
                    url.set("https://github.com/Hammwerk/material-color-palette")
                }

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://www.opensource.org/licenses/mit-license.php")
                    }
                }

                developers {
                    developer {
                        name.set("David Hamm")
                        email.set("david.hamm@hammwerk.de")
                        organization.set("Hammwerk")
                    }
                }
            }

            from(components["java"])
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications["maven"])
}

tasks.test {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}

dependencies {
    implementation(kotlin("stdlib", "1.5.0"))

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.15")

    testRuntimeOnly(kotlin("reflect", "1.5.0"))
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.15")
}