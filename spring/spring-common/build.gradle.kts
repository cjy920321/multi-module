import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") apply false
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.cjy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
    api(project(":common"))
}