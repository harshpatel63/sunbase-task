package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopicSubmissionsX(
    @Json(name = "arts-culture")
    val artsCulture: ArtsCulture,
    @Json(name = "history")
    val history: History,
    @Json(name = "monochrome")
    val monochrome: Monochrome,
    @Json(name = "nature")
    val nature: Nature,
    @Json(name = "textures-patterns")
    val texturesPatterns: TexturesPatterns,
    @Json(name = "wallpapers")
    val wallpapers: Wallpapers
)