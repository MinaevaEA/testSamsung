package com.example.pizza.retrofit

object Pizza {

    private const val BASE_URL = "https://order-pizza-api.herokuapp.com"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}