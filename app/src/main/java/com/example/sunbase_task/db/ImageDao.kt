package com.example.sunbase_task.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(image: Image)

    @Delete
    suspend fun deleteImage(image: Image)

    @Query("SELECT * FROM IMAGE_TABLE")
    fun getAllImages(): LiveData<List<Image>>

}