package com.example.sunbase_task.network

import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.network.properties.SearchObjectResponse
import com.example.sunbase_task.other.Constants.apiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Authorization: Client-ID $apiKey")
    @GET("photos")
    suspend fun getImages(): Response<ImageObjectResponse>

    @Headers("Authorization: Client-ID $apiKey")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") keyword: String
    ): Response<SearchObjectResponse>

}