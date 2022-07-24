plugins {
    kotlin("plugin.jpa") version "1.6.21"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
}