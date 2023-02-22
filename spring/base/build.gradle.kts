import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") apply false
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.cjy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(project(":common"))
    runtimeOnly("mysql:mysql-connector-java")
}

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}