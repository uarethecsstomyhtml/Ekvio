package com.example.android.ekvio

import android.app.Application
import androidx.multidex.MultiDex
import com.example.android.ekvio.BuildConfig.DEBUG
import com.example.android.ekvio.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


class BaseApp : Application() {

    private val modules = listOf(
        networkModule,
        apiModule,
        viewModelModule,
        repositoryModule,
        useCaseModule
    )

    override fun onCreate() {
        super.onCreate()
        initLogging()
        initKoin()
        initMultidex()
    }

    private fun initLogging() {
        if (DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            printLogger(level = Level.DEBUG)

            androidContext(this@BaseApp)

            modules(modules)
        }
    }

    private fun initMultidex() {
        MultiDex.install(this)
    }
}