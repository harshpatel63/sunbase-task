package com.example.sunbase_task.network.properties


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "alt_description")
    val altDescription: Any?,
    @Json(name = "blur_hash")
    val blurHash: String,
    @Json(name = "categories")
    val categories: List<Any>,
    @Json(name = "color")
    val color: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "current_user_collections")
    val currentUserCollections: List<Any>,
    @Json(name = "description")
    val description: Any?,
    @Json(name = "height")
    val height: Int,
    @Json(name = "id")
    val id: String,
    @Json(name = "liked_by_user")
    val likedByUser: Boolean,
    @Json(name = "likes")
    val likes: Int,
    @Json(name = "links")
    val links: LinksXXX,
    @Json(name = "promoted_at")
    val promotedAt: Any?,
    @Json(name = "sponsorship")
    val sponsorship: SponsorshipX?,
    @Json(name = "tags")
    val tags: List<Tag>,
    @Json(name = "topic_submissions")
    val topicSubmissions: TopicSubmissionsXX,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "urls")
    val urls: UrlsXX,
    @Json(name = "user")
    val user: UserXX,
    @Json(name = "width")
    val width: Int
)