plugins {
    kotlin("jvm") version "1.9.10" // Certifique-se de usar uma versão compatível do Kotlin
    kotlin("plugin.spring") version "1.9.10"
    kotlin("plugin.jpa") version "1.9.10" // Plugin para trabalhar com JPA
    id("org.springframework.boot") version "3.2.0" // Use uma versão compatível com seu projeto
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example" // Alterar para seu pacote
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17 // Alterar conforme necessário

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(17)) // Java versão 17, alterar conforme necessário
    }
}
