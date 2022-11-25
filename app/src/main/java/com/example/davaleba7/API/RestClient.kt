package com.example.retrofit.API

import com.example.retrofit.API.services.ReqResService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit
    val reqResService: ReqResService
        get() = createService(ReqResService::class.java)

    private val loggingInterceptor = HttpLoggingInterceptor()


    fun initClient() {
        loggingInterceptor
        okHttpClient = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    fun <T> createService(serviceInterface: Class<T>): T =
        retrofit.create(serviceInterface)


}