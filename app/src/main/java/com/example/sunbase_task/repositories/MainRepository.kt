package com.example.sunbase_task.repositories

import com.example.sunbase_task.db.Image
import com.example.sunbase_task.db.ImageDao
import com.example.sunbase_task.network.ApiHelper
import javax.inject.Inject


class MainRepository @Inject constructor(
    val imageDao: ImageDao,
    private val apiHelper: ApiHelper
) {
    suspend fun insertImage(image: Image) = imageDao.insertImage(image)

    suspend fun deleteImage(image: Image) = imageDao.deleteImage(image)

    suspend fun getImagesFromNetwork() = apiHelper.getImages()

    fun getAllImages() = imageDao.getAllImages()

}