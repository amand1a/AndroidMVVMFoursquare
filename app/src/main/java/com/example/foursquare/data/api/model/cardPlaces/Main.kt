package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable

@Serializable
data class Main(
    val latitude: Double,
    val longitude: Double
)