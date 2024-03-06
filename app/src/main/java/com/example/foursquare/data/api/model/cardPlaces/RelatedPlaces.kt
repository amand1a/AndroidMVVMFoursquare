package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Serializable


@Serializable
data class RelatedPlaces(
    val children: List<Children>? = null,
    val parent: Parent? = null
)