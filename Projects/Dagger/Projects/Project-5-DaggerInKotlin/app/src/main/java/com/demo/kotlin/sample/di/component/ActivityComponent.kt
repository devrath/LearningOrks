package com.demo.kotlin.sample.di.component

import com.demo.kotlin.sample.di.module.ActivityModule
import com.demo.kotlin.sample.di.ActivityScope
import com.demo.kotlin.sample.ui.main.MainActivity

import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}
