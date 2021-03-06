package com.demo.code.instagram.di.module

import androidx.lifecycle.LifecycleRegistry
import com.demo.code.instagram.di.ViewModelScope
import com.demo.code.instagram.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}