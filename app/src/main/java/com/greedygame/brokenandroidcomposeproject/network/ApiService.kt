package com.greedygame.brokenandroidcomposeproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("/v2/everything?q=android&apiKey=demo")
    suspend fun getArticles(): List<Map<String, Any>>
}

object ApiClient {
    val api: ApiService = Retrofit.Builder()
        .baseUrl("https://newsapi.org")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}