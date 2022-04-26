plugins {
    kotlin("jvm") version "1.6.21"

    id("org.quiltmc.loom") version "0.12.24"
}

repositories {
}

dependencies {
    implementation(kotlin("stdlib"))

    minecraft("com.mojang:minecraft:1.18.2")
    mappings(loom.layered {
        officialMojangMappings()
    })

    modImplementation("org.quiltmc:quilt-loader:0.16.0-beta.9") {
        setTransitive(false)
    }
    modImplementation("org.quiltmc:qsl:1.1.0-beta.2+1.18.2-SNAPSHOT") {
        exclude("org.quiltmc", "quilt-loader")
    }

    // modImplementation("org.quiltmc.quilted-fabric-api:quilted-fabric-api:1.0.0-beta.2+0.48.0-1.18.2")
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