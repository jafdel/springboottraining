plugins {
    java
    id("org.springframework.boot") version "4.1.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.jafdel.lil"
version = "0.0.1-SNAPSHOT"
description = "spring-room"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql:42.7.14")
    implementation("com.kohlschutter.junixsocket:junixsocket-core:2.11.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter")
    }
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-test")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
