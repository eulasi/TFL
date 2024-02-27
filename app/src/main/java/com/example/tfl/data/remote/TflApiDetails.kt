package com.example.tfl.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TflApiDetails {
    private const val BASE_URL = "https://api.tfl.gov.uk/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TflApiService by lazy {
        retrofit.create(TflApiService::class.java)
    }

}