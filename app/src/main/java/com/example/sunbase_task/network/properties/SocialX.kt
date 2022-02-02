package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SocialX(
    @Json(name = "instagram_username")
    val instagramUsername: String,
    @Json(name = "paypal_email")
    val paypalEmail: Any?,
    @Json(name = "portfolio_url")
    val portfolioUrl: Any?,
    @Json(name = "twitter_username")
    val twitterUsername: Any?
)