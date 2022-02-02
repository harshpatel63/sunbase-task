package com.example.sunbase_task.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(image: Image)

    @Query("DELETE FROM IMAGE_TABLE")
    suspend fun deleteImages()

    @Query("SELECT * FROM IMAGE_TABLE")
    fun getAllImages(): LiveData<List<Image>>

}