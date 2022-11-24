import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.vanniktech.maven.publish")
}

setupModuleForComposeMultiplatform()

android {
    namespace = "cafe.adriel.voyager.navigator"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.voyagerCore)
                compileOnly(compose.runtime)
                compileOnly(libs.composeMultiplatform.runtimeSaveable)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(libs.junit.api)
                runtimeOnly(libs.junit.engine)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.compose.activity)
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.ui)
            }
        }
    }
}
