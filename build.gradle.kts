plugins {
    kotlin("jvm") version "1.6.21"
}

group = "com.github.retroPacifist"
version = "1.0-SNAPSHOT"

repositories {
}

dependencies {
    implementation(kotlin("stdlib"))
}

allprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("java")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
    }
}

subprojects {

    dependencies {
        if (project.name != "common")
            implementation(project(":common"))
    }
}