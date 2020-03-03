import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.jvm.tasks.Jar

plugins {
    kotlin("jvm") version "1.3.50"
}

group = "com.javalin.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    /* Core Libraries */
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    /* Javalin Libraries */
    implementation("io.javalin:javalin:3.7.0")
    implementation("org.slf4j:slf4j-simple:1.7.30")

    /* Dependency Injection Libraries */
    implementation("com.authzee.kotlinguice4:kotlin-guice:1.2.0")
    implementation("com.google.inject:guice:4.2.2")

    /* Other */
    implementation("com.google.code.gson:gson:2.8.6")

    /* Test framework */
    implementation("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


val fatJar = task("fatJar", type = Jar::class) {
    baseName = "${project.name}-fat"
    manifest {
        attributes["Implementation-Title"] = "Building with this task will create a standalone executable jar."
        attributes["Implementation-Version"] = version
        attributes["Main-Class"] = "RunKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}
