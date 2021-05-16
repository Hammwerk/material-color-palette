plugins {
    kotlin("jvm") version "1.5.0"
}

group = "de.hammwerk"
version = "1.0.0"

repositories {
    mavenCentral()
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
