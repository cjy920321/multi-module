val slf4jVersion: String by project

plugins {
    kotlin("jvm")
}

group = "com.cjy"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
}