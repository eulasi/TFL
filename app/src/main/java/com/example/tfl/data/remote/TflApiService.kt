package com.example.tfl.data.remote

import com.example.tfl.data.networking.TflItem
import retrofit2.Response
import retrofit2.http.GET

interface TflApiService {
    @GET("Line/Mode/tube/Status")
    suspend fun getTubeStatus(): Response<List<TflItem>?>
}
