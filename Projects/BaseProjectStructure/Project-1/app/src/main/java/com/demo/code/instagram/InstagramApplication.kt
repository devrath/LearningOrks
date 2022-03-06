package com.demo.code.instagram

import android.app.Application
import com.demo.code.instagram.di.component.ApplicationComponent
import com.demo.code.instagram.di.component.DaggerApplicationComponent
import com.demo.code.instagram.di.module.ApplicationModule

class InstagramApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}