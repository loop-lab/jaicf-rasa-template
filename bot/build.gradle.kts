plugins {
    application
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "com.justai.jaicf"
version = "1.0.0"

val ktor = "1.5.1"
val jaicf = "1.2.2"
val slf4j = "1.7.30"

application {
    mainClassName = "com.justai.jaicf.template.channel.TelegramKt"
}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven(uri("https://jitpack.io"))
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.slf4j:slf4j-simple:$slf4j")
    implementation("org.slf4j:slf4j-log4j12:$slf4j")

    implementation("com.just-ai.jaicf:core:$jaicf")
    implementation("com.just-ai.jaicf:telegram:$jaicf")

    implementation("io.ktor:ktor-client-cio:$ktor")
    implementation("io.ktor:ktor-client-jackson:$ktor")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktor")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClassName
            )
        )
    }
}

tasks.create("stage") {
    dependsOn("shadowJar")
}
