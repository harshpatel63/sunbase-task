package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SocialXXXX(
    @Json(name = "instagram_username")
    val instagramUsername: Any?,
    @Json(name = "paypal_email")
    val paypalEmail: Any?,
    @Json(name = "portfolio_url")
    val portfolioUrl: String?,
    @Json(name = "twitter_username")
    val twitterUsername: String?
)