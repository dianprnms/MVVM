package com.example.mvvm.network

import com.example.mvvm.model.getUserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getUser(): Call<List<getUserItem>>
}