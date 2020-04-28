package com.pagingdemo.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.pagingdemo.data.local.dao.UserDao
import com.pagingdemo.factory.UserDataSourceFactory
import com.pagingdemo.model.UserEntity
import com.pagingdemo.utils.NetworkUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val usersDao: UserDao,
    val context: Context,
    private val userDataSourceFactory: UserDataSourceFactory
) {

    fun observePagedUsers() =
        if (NetworkUtils.isOnline(context)) {
            getDataFromRemote()
        } else {
            getDataFromLocal()
        }


    private fun getDataFromRemote(): LiveData<PagedList<UserEntity>> {
        return LivePagedListBuilder(
            userDataSourceFactory,
            UserDataSourceFactory.pagedListConfig()
        ).build()
    }

    private fun getDataFromLocal(): LiveData<PagedList<UserEntity>> {
        val dataSourceFactory = usersDao.getUsers()
        return LivePagedListBuilder(
            dataSourceFactory,
            UserDataSourceFactory.pagedListConfig()
        ).build()
    }

}