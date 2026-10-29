plugins {
    java
    id("org.springframework.boot") version "4.1.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.jafdel.lil"
version = "0.0.1-SNAPSHOT"
description = "room-web-app"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-jdbc")
        exclude(group = "org.springframework.boot", module = "spring-boot-hibernate")
    }
    implementation("org.springframework.boot:spring-boot-starter-jdbc") {
        exclude(group = "com.zaxxer", module = "HikariCP")
    }
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testCompileOnly("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.postgresql:postgresql")
    implementation("com.zaxxer:HikariCP:7.1.0")
    implementation("org.springframework.boot:spring-boot-hibernate") {
        exclude(group = "org.hibernate.orm", module = "hibernate-core")
    }
    implementation("org.hibernate.orm:hibernate-core:7.4.10.Final")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
