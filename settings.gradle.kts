pluginManagement {

    plugins {
        kotlin("jvm") version "1.6.21"
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "features-creatures"
include("shared")
