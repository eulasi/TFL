package com.example.tfl.dependencyinj

import com.example.tfl.data.remote.TflApiDetails
import com.example.tfl.data.remote.TflApiService
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
        return TflApiDetails.api
    }
}