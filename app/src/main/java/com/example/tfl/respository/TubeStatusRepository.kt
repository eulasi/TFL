package com.example.tfl.respository

import com.example.tfl.data.json.TflItem
import javax.inject.Inject
import com.example.tfl.remote.TflApiService
import retrofit2.Response

class TubeStatusRepository @Inject constructor(
    private val apiService: TflApiService
) {
    suspend fun getTubeStatus(): Response<List<TflItem>?> = apiService.getTubeStatus()
}