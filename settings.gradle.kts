pluginManagement {

    plugins {
        kotlin("jvm") version "1.6.21"
    }

    repositories {
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        maven {
            name = "Quilt"
            url = uri("https://maven.quiltmc.org/repository/release/")
        }
        maven {
            name = "SpongePowered"
            url = uri("https://repo.spongepowered.org/repository/maven-public/")
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "features-creatures"
include("common")
include("quilt")
include("forge")
include("fabric")
