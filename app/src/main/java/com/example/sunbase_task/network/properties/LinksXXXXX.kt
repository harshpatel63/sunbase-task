package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksXXXXX(
    @Json(name = "download")
    val download: String,
    @Json(name = "download_location")
    val downloadLocation: String,
    @Json(name = "html")
    val html: String,
    @Json(name = "self")
    val self: String
)