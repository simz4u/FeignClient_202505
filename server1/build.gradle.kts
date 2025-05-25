plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management")
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4") // springfw 3.2.5 와 mabatis-spring-boot-start:3.0.4 호환됨

    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.2")
    implementation("org.springframework.kafka:spring-kafka:3.1.1")


    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

val springCloudVersion = "2023.0.0"

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
