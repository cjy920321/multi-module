group = "com.cjy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation(project(":spring:common"))
    implementation(project(":ktor:file"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}