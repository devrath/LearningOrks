package com.demo.kotlin.sample.di.module

import android.content.Context

import com.demo.kotlin.sample.MyApplication
import com.demo.kotlin.sample.di.ApplicationContext
import com.demo.kotlin.sample.di.DatabaseInfo
import com.demo.kotlin.sample.di.NetworkInfo

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = "dummy_db"

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int = 1

    @Provides
    @NetworkInfo
    fun provideApiKey(): String = "SOME_API_KEY"
}
