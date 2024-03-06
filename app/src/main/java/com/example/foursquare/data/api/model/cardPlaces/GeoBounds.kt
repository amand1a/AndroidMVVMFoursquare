package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable


@Serializable
data class GeoBounds(
    val circle: Circle
)