package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val address: String? = null,
    val country: String,
    val cross_street:  String? = null,
    val formatted_address: String,
    val locality: String,
    val postcode: String? = null,
    val region: String
)