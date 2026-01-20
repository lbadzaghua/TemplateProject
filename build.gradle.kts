import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.spring") version "2.2.0" // automatically opens classes and methods (default qualifier is final) annotated or meta-annotated with Spring annotations
    kotlin("plugin.jpa") version "2.2.0" // generates no-arg constructors for any class annotated with @Entity, @MappedSuperclass or @Embeddable.
}

group = "org.templateproject"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("tools.jackson.module:jackson-module-kotlin:3.0.3") // serialization/deserialization
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.15") // OpenAPI
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.5.9")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:3.5.9")
    implementation("org.springframework.boot:spring-boot-starter-mustache:3.5.9")
    implementation("org.springframework.boot:spring-boot-starter-security:3.5.9")
    implementation("org.springframework.boot:spring-boot-starter-web:3.5.9")

    implementation(kotlin("reflect")) // Reflection is a set of language and library features that allows you to introspect the structure of your program at runtime

    runtimeOnly("org.postgresql:postgresql:42.7.9")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:3.5.9")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.5.9")
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict") // Spring nullability annotations provide null-safety for the whole Spring Framework API to Kotlin developers, with the advantage of dealing with null related issues at compile time.
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}