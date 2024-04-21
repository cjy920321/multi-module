val springCloudVersion: String by project

plugins {
    java
    id("io.spring.dependency-management")
}

subprojects {
    apply(plugin  = "io.spring.dependency-management")
    apply(plugin  = "java")
    apply(plugin  = "org.jetbrains.kotlin.plugin.spring")

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
        }
    }

    dependencies {
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
