package com.demo.code.instagram.di.component

import com.demo.code.instagram.di.ViewModelScope
import com.demo.code.instagram.di.module.ViewHolderModule
import com.demo.code.instagram.ui.dummies.DummyItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: DummyItemViewHolder)
}