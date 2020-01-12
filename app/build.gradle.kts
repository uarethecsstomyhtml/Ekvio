import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.navSafeArgs)
    id(BuildPlugins.project)
}

configure<BaseExtension> {

    android {
        (kotlinOptions as KotlinJvmOptions).apply {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    androidExtensions {
        isExperimental = true
    }
}
