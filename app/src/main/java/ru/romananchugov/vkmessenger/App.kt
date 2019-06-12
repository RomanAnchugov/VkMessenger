package ru.romananchugov.vkmessenger

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.romananchugov.vkmessenger.modules.viewModelsModule
import timber.log.Timber

class App: Application(){


    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(viewModelsModule)
        }
    }
}