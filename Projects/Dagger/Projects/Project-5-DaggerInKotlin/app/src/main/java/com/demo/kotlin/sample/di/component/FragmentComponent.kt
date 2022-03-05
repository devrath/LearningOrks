package com.demo.kotlin.sample.di.component

import com.demo.kotlin.sample.di.module.FragmentModule
import com.demo.kotlin.sample.di.FragmentScope
import com.demo.kotlin.sample.ui.home.HomeFragment

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}
