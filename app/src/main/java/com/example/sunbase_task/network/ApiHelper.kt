package com.example.sunbase_task.network

import com.example.sunbase_task.network.properties.ImageObjectResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getImages(): Response<ImageObjectResponse>
}