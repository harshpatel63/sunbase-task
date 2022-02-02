package com.example.sunbase_task.repositories

import com.example.sunbase_task.db.Image
import com.example.sunbase_task.db.ImageDao
import com.example.sunbase_task.network.ApiHelper
import com.example.sunbase_task.network.Resource
import com.example.sunbase_task.network.properties.ImageObjectResponse
import javax.inject.Inject


class MainRepository @Inject constructor(
    val imageDao: ImageDao,
    private val apiHelper: ApiHelper
) {
    suspend fun insertImage(image: Image) = imageDao.insertImage(image)

    suspend fun deleteAllImages() = imageDao.deleteImages()

    suspend fun getImagesFromNetwork() = apiHelper.getImages()

    suspend fun searchImageFromNetwork(keyword:String) = apiHelper.searchImages(keyword)

    fun getAllImages() = imageDao.getAllImages()

}