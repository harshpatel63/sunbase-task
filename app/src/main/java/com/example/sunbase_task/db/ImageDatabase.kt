package com.example.sunbase_task.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Image::class],
    version = 1
)
abstract class ImageDatabase : RoomDatabase() {

    abstract fun getImageDao(): ImageDao

}