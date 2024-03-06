package com.example.foursquare.data.api.model.detailItemApi

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val address: String? = null,
    val census_block: String? = null,
    val country: String,
    val dma: String? = null,
    val formatted_address: String,
    val locality: String? = null,
    val po_box: String? = null,
    val postcode: String? = null,
    val region: String
)