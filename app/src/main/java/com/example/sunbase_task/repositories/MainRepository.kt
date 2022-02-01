package com.example.sunbase_task.repositories

import com.example.sunbase_task.db.Image
import com.example.sunbase_task.db.ImageDao
import javax.inject.Inject


class MainRepository @Inject constructor(
    val imageDao: ImageDao
) {
    suspend fun insertImage(image: Image) = imageDao.insertImage(image)

    suspend fun deleteImage(image: Image) = imageDao.deleteImage(image)

    fun getAllImages() = imageDao.getAllImages()

}