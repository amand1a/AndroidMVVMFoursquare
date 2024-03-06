package com.example.foursquare.data.api.model.cardPlaces

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Result(

    val categories: List<Category>,
    @Contextual
    val someProperty: Any? = null,
    val closed_bucket: String,
    val distance: Int,
    val fsq_id: String,
    val geocodes: Geocodes,
    val link: String,
    val location: Location? = null,
    val name: String,
    val related_places: RelatedPlaces,
    val timezone: String
)