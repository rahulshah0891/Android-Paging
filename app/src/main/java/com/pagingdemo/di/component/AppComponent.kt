package com.pagingdemo.di.component

import android.app.Application
import com.pagingdemo.PagingApp
import com.pagingdemo.di.builder.ActivityBuilder
import com.pagingdemo.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        ApiModule::class,
        DatabaseModule::class,
        AppModule::class,
        UserDataSourceFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<PagingApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: PagingApp)
}