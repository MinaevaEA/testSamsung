package com.example.pizza.retrofit

import android.telecom.Call
import com.google.gson.JsonObject
import retrofit2.http.GET


interface RetrofitServices {
    @GET("/api/orders")
    fun getAll(): JsonObject

}