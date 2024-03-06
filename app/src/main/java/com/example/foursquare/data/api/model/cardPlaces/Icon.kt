package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable

@Serializable
data class Icon(
    val prefix: String,
    val suffix: String
)