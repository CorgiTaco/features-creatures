plugins {
    kotlin("jvm") version "1.6.21"

    id("org.spongepowered.gradle.vanilla") version "0.2.1-SNAPSHOT"
}

repositories {
}

dependencies {
    implementation(kotlin("stdlib"))

    compileOnly("org.spongepowered:mixin:0.8.4")
}

minecraft {
    version("1.18.2")
    runs {
        server()
        client()
    }
}
