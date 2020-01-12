
object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val ktlintGradlePlugin = "org.jlleitschuh.gradle.ktlint"
    const val navSafeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Jetpack.nav}"

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val navSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val project = "com.example.android.ekvio"
}

object ConfigurationName {
    const val kapt = "kapt"
    const val implementation = "implementation"
    const val testImplementation = "testImplementation"
    const val androidTestImplementation = "androidTestImplementation"
}

object Tasks {
    const val clean = "clean"
}

object AndroidSdk {
    const val compile = 29
    const val min = 19
    const val target = 29
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Release {
    const val appId = "com.example.android.ekvio"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val   gradle = "3.5.2"
    const val androidBuildToolsVersion = "29.0.2"

    const val kotlin = "1.3.50"
    const val ktx = "1.1.0"
    const val multidex = "2.0.1"
    const val ktlint = "0.34.2"
    const val ktlintPlugin = "9.1.0"


    object Jetpack {
        const val nav = "2.1.0"
        const val room = "2.2.1"
    }

    object DI {
        const val koin = "2.0.1"
    }
    object Support {
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val material = "1.0.0"
        const val media2 = "1.0.1"
    }

    object Image {
        const val glide = "4.9.0"
    }

    object Logging {
        const val timber = "4.7.1"
    }

    object Network {
        const val retrofit = "2.6.2"
        const val okHttp = "4.2.2"
        const val gson = "2.3.0"
        const val loggingInterceptor = "4.2.1"
    }

    object GooglePlayService {
        const val ads = "18.3.0"
        const val location = "17.0.0"
    }

    object Test {
        const val junit = "4.12"
        const val espresso = "3.2.0"
        const val koin = "2.0.1"
    }
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    object Groupie {
        const val groupie = "com.xwray:groupie:2.7.0"
        const val groupieKotlinExt = "com.xwray:groupie-kotlin-android-extensions:2.7.0"
    }

    object Jetpack {
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Jetpack.nav}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.Jetpack.nav}"
        const val room = "androidx.room:room-runtime:${Versions.Jetpack.room}"
        const val roomKapt = "androidx.room:room-compiler:${Versions.Jetpack.room}"
        const val roomCoroutines = "androidx.room:room-ktx:${Versions.Jetpack.room}"
    }

    object DI {
        const val koinAndroid = "org.koin:koin-android:${Versions.DI.koin}"
        const val koinScope = "org.koin:koin-androidx-scope:${Versions.DI.koin}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.DI.koin}"
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Image.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Image.glide}"
    }

    object Logging {
        const val timber = "com.jakewharton.timber:timber:${Versions.Logging.timber}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.Network.okHttp}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.Network.gson}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Network.loggingInterceptor}"
    }

    object Support {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Support.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Support.constraintLayout}"
        const val material = "com.google.android.material:material:${Versions.Support.material}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
        const val koin = "org.koin:koin-test:${Versions.Test.koin}"
    }
}

