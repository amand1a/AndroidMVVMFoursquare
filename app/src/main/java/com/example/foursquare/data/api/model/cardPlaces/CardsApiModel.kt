package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable

@Serializable
data class CardsApiModel(
    val context: Context,
    val results: List<Result>
)