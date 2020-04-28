package com.pagingdemo.data.remote

import com.pagingdemo.model.UserListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val API_URL = "https://reqres.in/"
    }

    @GET("api/users")
    suspend fun fetchUsers(
        @Query("page") number: Int,
        @Query("per_page") per_page: Int
    ): Response<UserListResponse>

}