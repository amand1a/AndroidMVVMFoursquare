package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable


@Serializable
data class Category(
    val icon: Icon,
    val id: Int,
    val name: String,
    val plural_name: String,
    val short_name: String
)