package com.demo.code.instagram.di.component

import com.demo.code.instagram.di.FragmentScope
import com.demo.code.instagram.di.module.FragmentModule
import com.demo.code.instagram.ui.dummies.DummiesFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: DummiesFragment)
}