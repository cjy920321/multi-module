val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val amazonawsVersion: String by project

plugins {
    application
    kotlin("jvm")
}

group = "com.cjy"
version = "0.0.1"
application {
    mainClass.set("com.cjy.ApplicationKt")
}
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("com.googlecode.soundlibs:jlayer:1.0.1.4")
    implementation("com.amazonaws:aws-java-sdk-s3:$amazonawsVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}