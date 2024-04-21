val slf4jVersion: String by project

plugins {
    kotlin("jvm")
}

group = "com.cjy"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
}