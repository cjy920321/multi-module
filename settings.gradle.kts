rootProject.name = "multi-module"

include(":common",
        ":spring:spring-common",
        ":spring:base",
        ":spring:auth",
        ":spring:task",
        ":spring:feign",
        ":ktor:file")