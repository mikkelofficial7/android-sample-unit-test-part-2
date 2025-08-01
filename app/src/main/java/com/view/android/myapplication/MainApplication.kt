package com.view.android.myapplication

import android.app.Application
import com.view.android.myapplication.core.koin.appModule
import com.view.android.myapplication.core.koin.repoModule
import com.view.android.myapplication.core.koin.useCaseModule
import com.view.android.myapplication.core.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.*

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(appModule, repoModule, useCaseModule, viewModelModule))
        }
    }
}