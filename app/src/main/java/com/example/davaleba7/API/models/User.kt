package com.example.retrofit.API.models

import com.google.gson.annotations.SerializedName

data class User(
    var id: Long,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("last_name")
    var lastName: String,
    var email: String,
    var avatar: String

)
