package com.demo.code.instagram.di.component

import com.demo.code.instagram.di.ActivityScope
import com.demo.code.instagram.di.module.ActivityModule
import com.demo.code.instagram.ui.dummy.DummyActivity
import com.demo.code.instagram.ui.splash.SplashActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: DummyActivity)
}