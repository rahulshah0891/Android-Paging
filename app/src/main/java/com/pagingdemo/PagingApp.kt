package com.pagingdemo

import android.app.Application
import com.pagingdemo.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class PagingApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().create(this).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}