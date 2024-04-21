buildscript {

    val springBootVersion: String by project
    val springBootManagementVersion: String by project
    val kotlinVersion: String by project

    repositories {
        mavenLocal()
        maven (
            url = "https://maven.aliyun.com/repository/central"
        )
        maven (
            url = "https://maven.aliyun.com/repository/public"
        )
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("io.spring.gradle:dependency-management-plugin:$springBootManagementVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    }
}

allprojects {
    repositories {
        mavenLocal()
        maven (
            url = "https://maven.aliyun.com/repository/central"
        )
        maven (
            url = "https://maven.aliyun.com/repository/public"
        )
        mavenCentral()
    }
}

subprojects {
    apply(plugin  = "java-library")
}