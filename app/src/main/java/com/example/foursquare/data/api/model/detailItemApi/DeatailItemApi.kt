package com.example.foursquare.data.api.model.detailItemApi

import kotlinx.serialization.Serializable

@Serializable
data class DeatailItemApi(
    val categories: List<Category>,
    val chains: List<String>,
    val closed_bucket: String,
    val fsq_id: String,
    val geocodes: Geocodes,
    val link: String,
    val location: Location,
    val name: String,
    val related_places: RelatedPlaces,
    val timezone: String
)