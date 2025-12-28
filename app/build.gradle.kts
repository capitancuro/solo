plugins {
    // 1. Pure Java and Application support
    java
    application

    // 2. Keep JavaFX support (if you still want it for UI overlays)
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "com.keno.solo"
version = "1.0"

repositories {
    mavenCentral()
}

// Helper to determine the host OS for native binaries
val lwjglNatives = when (System.getProperty("os.name").lowercase()) {
    "mac os x" -> "natives-macos"
    "linux"    -> "natives-linux"
    else       -> "natives-windows"
}

dependencies {
    // 3. Application and Utility dependencies
    implementation(libs.guava)

    // 4. LWJGL 3 Dependencies (Using BOM for version management)
    val lwjglVersion = "3.3.4"
    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))

    implementation("org.lwjgl", "lwjgl")
    implementation("org.lwjgl", "lwjgl-glfw")
    implementation("org.lwjgl", "lwjgl-opengl")
    implementation("org.lwjgl", "lwjgl-stb") // For loading images

    // 5. LWJGL Native Binaries
    runtimeOnly("org.lwjgl", "lwjgl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-stb", classifier = lwjglNatives)

    // 6. Math Library (Essential for game/emulator logic)
    implementation("org.joml", "joml", "1.10.5")

    // 7. Testing dependencies
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// 8. Java 21 Toolchain
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
    mainClass = "com.keno.solo.Main" // Ensure this matches your new entry point
}

// 9. Standard Input Support for CLI interaction
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    
    // macOS requirement for LWJGL 3
    if (System.getProperty("os.name").lowercase().contains("mac")) {
        jvmArgs("-XstartOnFirstThread")
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}