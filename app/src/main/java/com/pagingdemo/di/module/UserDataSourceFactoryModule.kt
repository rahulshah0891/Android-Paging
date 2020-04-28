package com.pagingdemo.di.module

import com.pagingdemo.data.local.dao.UserDao
import com.pagingdemo.data.remote.ApiService
import com.pagingdemo.factory.UserDataSourceFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module
class UserDataSourceFactoryModule {

    @Provides
    fun provideUserDataSourceFactory(
        userDao: UserDao,
        scope: CoroutineScope,
        apiService: ApiService
    ) = UserDataSourceFactory(
        userDao,
        scope,
        apiService
    )
}