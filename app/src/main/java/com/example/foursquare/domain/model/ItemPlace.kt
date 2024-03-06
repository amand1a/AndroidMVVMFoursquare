package com.example.foursquare.domain.model



data class ItemPlace (
    val id: String ,
    val images: ArrayList <String>,
    val beenHere: Int,
    val categories: String,
    val contact: String ,
    val hereNow: Int,
    val location: String,
    val name: String
)
