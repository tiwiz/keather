import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("kotlinx-serialization")
}

version = "1.0.1"

kotlin {
    //select iOS target platform depending on the Xcode environment variables
    /** Kotlin/iOS build target */
    ios {
        //TODO temporary workaround, see KT-36804
        tasks.getByName("compileTestKotlin" + name.capitalize())
    }

    jvm("android")

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
        implementation("io.ktor:ktor-client-core:1.3.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.3-native-mt")
        implementation("io.ktor:ktor-client-serialization:1.3.0")
        implementation("io.ktor:ktor-client-json:1.3.0")
    }

    sourceSets["androidMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        implementation("io.ktor:ktor-client-android:1.3.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")
        implementation("io.ktor:ktor-client-serialization-jvm:1.3.0")
        implementation("io.ktor:ktor-client-json-jvm:1.3.0")
    }

    sourceSets["iosMain"].dependencies {
        implementation("io.ktor:ktor-client-ios:1.3.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.3.3-native-mt")
        implementation("io.ktor:ktor-client-serialization-native:1.3.0")
        implementation("io.ktor:ktor-client-json-native:1.3.0")
    }

    cocoapods {
        /** Configure the following fields, as required by CocoaPods. */
        /** The version is obtained from Gradle [Project.getVersion]. */
        summary = "summary"
        homepage = "homepage"
    }
}