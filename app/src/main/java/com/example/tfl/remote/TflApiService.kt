package com.example.tfl.remote

import com.example.tfl.data.json.TflItem
import retrofit2.Response
import retrofit2.http.GET

interface TflApiService {
    @GET("Line/Mode/tube/Status")
    suspend fun getTubeStatus(): Response<List<TflItem>?>
}
