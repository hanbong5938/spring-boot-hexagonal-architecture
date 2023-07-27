import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    val kotlinVersion = "1.8.21"
    val springBootVersion = "3.1.2"
    id("org.springframework.boot").version(springBootVersion)
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
}


repositories {
    mavenCentral()
}


allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencies {
        api("org.jetbrains.kotlin:kotlin-reflect")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-spring")

    dependencies {
        api("org.springframework.boot:spring-boot-starter-actuator")
        testApi("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

project(":domain") {
    tasks {
        withType<Jar> { enabled = true }
        withType<BootJar> { enabled = false }
    }

    dependencies {
        testApi("org.junit.jupiter:junit-jupiter:5.10.0")
    }
}



project(":application") {
    dependencies {
        api(project(":domain"))
    }
}
