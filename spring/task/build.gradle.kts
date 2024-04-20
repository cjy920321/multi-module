import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") apply false
}

group = "com.cjy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-quartz")
    api(project(":spring:spring-common"))
}

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}