package com.example.retrofit.API.services

import com.example.retrofit.API.models.ReqResData
import com.example.retrofit.API.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqResService {


    @GET("users")

    fun getUsers(@Query("page") page: Int): Call<ReqResData<User>>


    @GET("users/{id}")
    fun getUser(@Path("id") id: Long): Call<ReqResData<User>>



}