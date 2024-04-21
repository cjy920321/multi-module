val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val amazonawsVersion: String by project

plugins {
    application
    kotlin("jvm")
    id("io.ktor.plugin")
}

group = "com.cjy"
version = "0.0.1"
application {
    mainClass.set("com.cjy.ApplicationKt")
}
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}