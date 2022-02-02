package com.example.sunbase_task.network

import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.other.Constants.apiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Authorization: Client-ID $apiKey")
    @GET("photos")
    suspend fun getImages(): Response<ImageObjectResponse>

}