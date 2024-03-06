package com.example.foursquare.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "places")
data class Place (
  @PrimaryKey
    val id: String ,
    val image: String,
    val namePlace: String,
    val typePlace: String
)