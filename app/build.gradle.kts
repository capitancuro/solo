plugins {
    // 1. Pure Java and Application support
    java
    application

    // 2. Desktop UI support
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/releases/") }
}

val gdxVersion = "1.14.0"

dependencies {
    // 3. Application and Utility dependencies
    implementation(libs.guava)

    // 4. LibGDX dependencies
    implementation("com.badlogicgames.gdx:gdx:$gdxVersion")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
    implementation("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")

    // 5. Testing dependencies
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// 6. Simplified Source Sets (Back to Java standards)
sourceSets {
    main {
        java.srcDirs("src/main/java")
    }
}

// 7. Java 21 Toolchain
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

javafx {
    version = "21"
    modules("javafx.controls", "javafx.fxml")
}

application {
    mainClass = "com.keno.solo.App"
}

// 8. Standard Input Support for CLI interaction
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}