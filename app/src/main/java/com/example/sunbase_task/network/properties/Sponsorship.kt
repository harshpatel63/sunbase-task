package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sponsorship(
    @Json(name = "impression_urls")
    val impressionUrls: List<String>,
    @Json(name = "sponsor")
    val sponsor: Sponsor,
    @Json(name = "tagline")
    val tagline: String,
    @Json(name = "tagline_url")
    val taglineUrl: String
)