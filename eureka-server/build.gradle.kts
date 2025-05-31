plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.7"
    java
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val springCloudVersion = "2023.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

// 메인 클래스 경로 꼭 본인 프로젝트 구조에 맞게 수정하세요
tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("com.example.eurekaserver.EurekaServerApplication")
}
