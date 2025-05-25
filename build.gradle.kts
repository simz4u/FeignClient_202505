import org.gradle.kotlin.dsl.the

plugins {
    id("io.spring.dependency-management") version "1.1.7" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.23" apply false
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "io.spring.dependency-management")

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
        }
    }
}
