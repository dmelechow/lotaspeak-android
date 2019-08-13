package com.lotaspeak.speak.di.app

import com.lotaspeak.speak.App
import com.lotaspeak.speak.data.network.RestApi
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class), (NetworkModule::class), (CacheModule::class)])
interface AppComponent {

    fun inject(app: App)

    fun restApi(): RestApi

    fun retrofit(): Retrofit

    fun okHttpClientBuilder(): OkHttpClient.Builder

//    fun coockie(): ClearableCookieJar
//
//    fun gson(): Gson
//
//    fun baseDataLocalStore(): BaseLocalDataSource
//
}