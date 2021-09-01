import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.5.30"
}

group = "me.leon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val daggerVersion = "2.36"

dependencies {
    testImplementation(kotlin("test-junit"))

    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation ("com.google.dagger:dagger:$daggerVersion")

    implementation ("com.google.code.gson:gson:2.8.8")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}