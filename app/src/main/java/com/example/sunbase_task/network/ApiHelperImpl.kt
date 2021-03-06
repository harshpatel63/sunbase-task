package com.example.sunbase_task.network

import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.network.properties.SearchObjectResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
): ApiHelper {
    override suspend fun getImages(): Response<ImageObjectResponse> = apiService.getImages()
    override suspend fun searchImages(keyword: String): Response<SearchObjectResponse> = apiService.searchImages(keyword)
}