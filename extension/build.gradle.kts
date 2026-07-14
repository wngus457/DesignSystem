import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
}

val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        load(localPropertiesFile.inputStream())
    }
}


android {
    namespace = "com.juhyeon.androidds.extension"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.compose.navigation)

    implementation(libs.coil.core)
    implementation(libs.coil.compose)
}

android {
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

afterEvaluate {
    extensions.configure<PublishingExtension> {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.juhyeon.androidds"
                artifactId = "extension"
                version = "1.0.2"

                pom {
                    name.set("AndroidDS Extension")
                    description.set("Extension library for Android Design System")
                }
            }
        }
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_REPOSITORY") ?: "wngus457/DesignSystem"}")
                credentials {
                    username = System.getenv("GITHUB_ACTOR") ?: ""
                    password = System.getenv("GITHUB_TOKEN") ?: ""
                }
            }
        }
    }
}