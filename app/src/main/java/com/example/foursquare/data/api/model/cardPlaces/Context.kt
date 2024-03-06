package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable


@Serializable
data class Context(
    val geo_bounds: GeoBounds
)