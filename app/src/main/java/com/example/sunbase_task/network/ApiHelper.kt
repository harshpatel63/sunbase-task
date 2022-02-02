package com.example.sunbase_task.network

import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.network.properties.SearchObjectResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getImages(): Response<ImageObjectResponse>
    suspend fun  searchImages(keyword: String): Response<SearchObjectResponse>
}