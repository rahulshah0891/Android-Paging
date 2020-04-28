package com.pagingdemo.di.module

import androidx.lifecycle.ViewModelProvider
import com.pagingdemo.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}