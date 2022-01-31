package com.example.sunbase_task.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class Image(
    var imgLink: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}