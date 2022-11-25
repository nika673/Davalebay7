package com.example.davaleba7



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.API.RestClient
import com.example.retrofit.API.models.ReqResData
import com.example.retrofit.API.models.User
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.initClient()
        RestClient.reqResService.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>>)
        @Override fun onResponse(
            call:
        )




    }

}