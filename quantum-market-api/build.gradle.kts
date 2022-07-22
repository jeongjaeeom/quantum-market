tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":support:logging"))
    implementation(project(":catalogs:api"))
    implementation(project(":orders:order-api"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}