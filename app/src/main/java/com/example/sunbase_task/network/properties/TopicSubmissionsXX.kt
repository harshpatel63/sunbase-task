package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopicSubmissionsXX(
    @Json(name = "architecture-interior")
    val architectureInterior: ArchitectureInterior,
    @Json(name = "business-work")
    val businessWork: BusinessWork,
    @Json(name = "covid-19")
    val covid19: Covid19,
    @Json(name = "interiors")
    val interiors: Interiors,
    @Json(name = "wallpapers")
    val wallpapers: WallpapersX
)