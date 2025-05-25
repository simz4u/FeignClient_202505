rootProject.name = "FeignClient"

include("common", "server1", "server2")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
