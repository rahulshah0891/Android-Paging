package com.pagingdemo.di.module

import androidx.lifecycle.ViewModel
import com.pagingdemo.ui.main.MainViewModel
import com.pagingdemo.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}