package com.example.tfl.module

import com.example.tfl.remote.RetrofitInstance
import com.example.tfl.remote.TflApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideTflApiService(): TflApiService {
        return RetrofitInstance.api
    }
}