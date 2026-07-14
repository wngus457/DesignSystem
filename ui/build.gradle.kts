plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

android {
    namespace = "com.juhyeon.androidds.ui"
    compileSdk = 35
    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(projects.extension)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    implementation(libs.coil.core)
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    implementation(libs.accompainst.permission)
    implementation(libs.lottie.compose)
    implementation(libs.serialization)
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
                artifactId = "ui"
                version = "1.0.2"

                pom {
                    name.set("AndroidDS UI")
                    description.set("UI library for Android Design System")
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