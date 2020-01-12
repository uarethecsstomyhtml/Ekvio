import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


open class EkvioAppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureAndroid()
        project.configureDependencies()
    }
}

internal fun Project.configureAndroid() = this.extensions.getByType<BaseExtension>().run {
    buildToolsVersion(Versions.androidBuildToolsVersion)
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = Release.appId
        versionCode = Release.versionCode
        versionName = Release.versionName

        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)

        testInstrumentationRunner = AndroidSdk.testInstrumentationRunner

        javaCompileOptions {
            annotationProcessorOptions {
                includeCompileClasspath = false
            }
        }
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

internal fun Project.configureDependencies() = dependencies {
    add(ConfigurationName.implementation, Libraries.kotlin)
    add(ConfigurationName.implementation, Libraries.ktx)
    add(ConfigurationName.implementation, Libraries.multidex)

    add(ConfigurationName.implementation, Libraries.DI.koinAndroid)
    add(ConfigurationName.implementation, Libraries.DI.koinScope)
    add(ConfigurationName.implementation, Libraries.DI.koinViewModel)

    add(ConfigurationName.implementation, Libraries.Groupie.groupie)
    add(ConfigurationName.implementation, Libraries.Groupie.groupieKotlinExt)

    add(ConfigurationName.implementation, Libraries.Jetpack.navFragment)
    add(ConfigurationName.implementation, Libraries.Jetpack.navUi)
    add(ConfigurationName.implementation, Libraries.Jetpack.room)
    add(ConfigurationName.kapt, Libraries.Jetpack.roomKapt)

    add(ConfigurationName.implementation, Libraries.Jetpack.roomCoroutines)

    add(ConfigurationName.implementation, Libraries.Image.glide)
    add(ConfigurationName.kapt, Libraries.Image.glideCompiler)

    add(ConfigurationName.implementation, Libraries.Logging.timber)

    add(ConfigurationName.implementation, Libraries.Network.retrofit)
    add(ConfigurationName.implementation, Libraries.Network.okHttp)
    add(ConfigurationName.implementation, Libraries.Network.gson)
    add(ConfigurationName.implementation, Libraries.Network.loggingInterceptor)

    add(ConfigurationName.implementation, Libraries.Support.appCompat)
    add(ConfigurationName.implementation, Libraries.Support.constraintLayout)
    add(ConfigurationName.implementation, Libraries.Support.material)

    add(ConfigurationName.androidTestImplementation, Libraries.Test.espresso)
    add(ConfigurationName.testImplementation, Libraries.Test.junit)
    add(ConfigurationName.testImplementation, Libraries.Test.koin)
}

