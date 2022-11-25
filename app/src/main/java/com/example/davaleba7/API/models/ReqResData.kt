package com.example.retrofit.API.models

import com.google.gson.annotations.SerializedName

data class ReqResData<T>(
    val page: Int,
    @SerializedName("per_page")
    var perPage: Int,
    var total: Int,
    @SerializedName("total_page")
    var totalPages: Int,
    val data: T

)
