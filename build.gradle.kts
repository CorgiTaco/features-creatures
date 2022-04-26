plugins {
    kotlin("jvm")
}

group = "com.github.retroPacifist"
version = "1.0-SNAPSHOT"

repositories {
}

dependencies {
}

allprojects {
    apply {
        plugin("kotlin")
        plugin("java")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib"))
    }
}