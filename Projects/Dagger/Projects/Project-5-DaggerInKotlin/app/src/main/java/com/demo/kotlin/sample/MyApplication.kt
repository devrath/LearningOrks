package com.demo.kotlin.sample

import android.app.Application

import com.demo.kotlin.sample.data.local.DatabaseService
import com.demo.kotlin.sample.data.remote.NetworkService
import com.demo.kotlin.sample.di.component.ApplicationComponent
import com.demo.kotlin.sample.di.component.DaggerApplicationComponent
import com.demo.kotlin.sample.di.module.ApplicationModule

import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var databaseService: DatabaseService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }
}