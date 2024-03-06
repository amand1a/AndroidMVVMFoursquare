package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable


@Serializable
data class Circle(
    val center: Center,
    val radius: Int
)