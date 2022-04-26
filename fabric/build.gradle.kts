plugins {
    kotlin("jvm") version "1.6.21"

    id("fabric-loom") version "0.11-SNAPSHOT"
}

repositories {
}

dependencies {
    implementation(kotlin("stdlib"))

    minecraft("com.mojang:minecraft:1.18.2")
    mappings(loom.layered {
        officialMojangMappings()
    })

    modImplementation("net.fabricmc:fabric-loader:0.13.3") {
        setTransitive(false)
    }

    modImplementation("net.fabricmc.fabric-api:fabric-api:0.47.8+1.18.2")
}

loom {
    runs {
        named("client") {
            client()
            ideConfigGenerated(true)
            runDir("run")
        }

        named("server") {
            server()
            ideConfigGenerated(true)
            runDir("run")
        }
    }
}