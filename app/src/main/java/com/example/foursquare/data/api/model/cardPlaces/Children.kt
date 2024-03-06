package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable


@Serializable
data class Children(
    val categories: List<Category>,
    val fsq_id: String,
    val name: String
)