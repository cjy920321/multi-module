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
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("com.googlecode.soundlibs:jlayer:1.0.1.4")
    implementation("com.amazonaws:aws-java-sdk-s3:$amazonawsVersion")
}