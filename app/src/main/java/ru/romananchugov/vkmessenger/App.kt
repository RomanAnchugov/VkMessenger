package ru.romananchugov.vkmessenger

import android.app.Application
import com.vk.api.sdk.VK
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.romananchugov.vkmessenger.di.useCaseModule
import ru.romananchugov.vkmessenger.di.viewModelsModule
import ru.romananchugov.vkmessenger.utils.InternetUtils
import timber.log.Timber

class App: Application(){


    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        InternetUtils.init(this)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelsModule, useCaseModule))
        }

        VK.initialize(this)
    }
}