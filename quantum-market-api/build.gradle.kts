tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":support:logging"))
    implementation(project(":quantum-market-application"))
    implementation(project(":quantum-market-domain"))
    implementation(project(":quantum-market-infrastructure:storage-main"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
