package com.example.foursquare.data.api.model.itemApi

import kotlinx.serialization.Serializable

@Serializable
data class Tip(
    val agree_count: Int,
    val created_at: String,
    val disagree_count: Int,
    val id: String,
    val lang: String,
    val text: String,
    val url: String
)