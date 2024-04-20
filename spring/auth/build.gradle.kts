plugins {
    id("org.springframework.boot")
}

group = "com.cjy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(project(":spring:base"))
    implementation(project(":spring:task"))
    implementation(project(":spring:feign"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

