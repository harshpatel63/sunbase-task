package com.example.sunbase_task.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
public class Image {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var bitmapImage: ByteArray? = null
}