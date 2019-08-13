package com.lotaspeak.speak

import android.app.Application
import android.content.res.Resources
import com.lotaspeak.speak.di.app.AppComponent
import com.lotaspeak.speak.di.app.AppModule
import com.lotaspeak.speak.di.app.DaggerAppComponent
import com.lotaspeak.speak.di.app.NetworkModule


class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent

        private lateinit var mInstance: App

        val instance: App
            get() = mInstance

        val resource: Resources
            get() = mInstance.resources
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        mInstance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(BuildConfig.SIZE_OF_CACHE.toLong()))
            .build()

        appComponent.inject(this)

    }
}