package com.lotaspeak.speak.di.app

import com.lotaspeak.speak.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private var app: App) {

    @Provides
    @Singleton
    internal fun provideContext() = app

}