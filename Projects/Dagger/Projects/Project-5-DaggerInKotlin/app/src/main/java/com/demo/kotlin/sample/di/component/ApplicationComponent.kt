package com.demo.kotlin.sample.di.component

import android.content.Context
import com.demo.kotlin.sample.MyApplication
import com.demo.kotlin.sample.data.local.DatabaseService
import com.demo.kotlin.sample.data.remote.NetworkService
import com.demo.kotlin.sample.di.ApplicationContext
import com.demo.kotlin.sample.di.module.ApplicationModule
import com.demo.kotlin.sample.utils.NetworkHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper
}
