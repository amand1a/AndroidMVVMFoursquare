package com.example.foursquare.data.api.model.detailItemApi

import kotlinx.serialization.Serializable

@Serializable
data class Geocodes(
    val main: Main,
    val roof: Roof? = null
)