plugins {
    id("fabric-loom") version "0.12-SNAPSHOT"
    id("io.github.juuxel.loom-quiltflower") version "1.7.3"
}

group = "me.obsilabor"
version = "1.0.0+mc1.19"

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.19")
    mappings("net.fabricmc:yarn:1.19+build.4")
    modImplementation("net.fabricmc:fabric-loader:0.14.8")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.56.3+1.19")
}

tasks {
    compileJava {
        options.release.set(17)
        options.encoding = "UTF-8"
    }
    processResources {
        val props = mapOf(
            "version" to project.version
        )
        inputs.properties(props)
        filesMatching("fabric.mod.json") {
            expand(props)
        }
    }
}