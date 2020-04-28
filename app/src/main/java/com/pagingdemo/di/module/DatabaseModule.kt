package com.pagingdemo.di.module

import android.app.Application
import com.pagingdemo.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(application: Application) = AppDatabase.invoke(application)

    @Singleton
    @Provides
    fun providesUserDao(database: AppDatabase) = database.userDao()
}