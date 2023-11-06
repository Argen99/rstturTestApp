package com.example.rstturtestapp

import android.app.Application
import com.example.data.koin.dataModule
import com.example.domain.koin.domainModule
import com.example.rstturtestapp.koin.appModule
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}