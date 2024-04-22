rootProject.name = "multi-module"

include(":core:common",
        ":core:file",
        ":spring:core:spring-common",
        ":spring:core:spring-base",
        ":spring:core:spring-task",
        ":spring:service:spring-auth-service",
        ":ktor:service:ktor-file-service")