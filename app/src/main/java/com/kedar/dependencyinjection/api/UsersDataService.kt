package com.kedar.dependencyinjection.api

import com.kedar.dependencyinjection.api.model.UsersDetail
import retrofit2.Call
import retrofit2.http.GET

interface UsersRetrofitService {
    @GET("api/users?page=1")
    fun getUsers(): Call<UsersDetail>
}