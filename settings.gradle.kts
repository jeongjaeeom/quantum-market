rootProject.name = "quantum-market"
include(
    "quantum-market-api",
    "support:common",
    "support:logging",
//    "catalogs:api",
//    "catalogs:modules:domain",
//    "catalogs:modules:rds",
//    "orders:order-api",
//    "orders:modules:domain",
//    "orders:modules:rds",
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
            }
        }
    }
}