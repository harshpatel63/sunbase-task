package com.example.sunbase_task.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Image::class],
    version = 1
)
abstract class ImageDatabase : RoomDatabase() {

    abstract fun getImageDao(): ImageDao

}