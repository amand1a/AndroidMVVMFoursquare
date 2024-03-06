package com.example.foursquare.data.api.model.itemApi

import kotlinx.serialization.Serializable

@Serializable
data class PhotosItemApiItem(
    val classifications: List<String>? = null,
    val created_at: String,
    val height: Int,
    val id: String,
    val prefix: String,
    val suffix: String,
    val tip: Tip? = null,
    val width: Int
)