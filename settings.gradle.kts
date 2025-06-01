rootProject.name = "FeignClient"

include("common", "server1", "server2", "server3")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include("eureka-server")