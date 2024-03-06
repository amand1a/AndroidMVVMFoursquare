package com.example.foursquare.domain

import com.example.foursquare.data.database.models.Place
import com.example.foursquare.domain.model.Card
import com.example.foursquare.domain.model.ItemPlace
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getPlacesHistoryFromStore(): Flow<List<Card>>

   suspend fun getPlacesAroundFromApi(token: String): ArrayList<Card>

   suspend fun getItemPhotosFromApi(token: String, id: String): ArrayList<String>

    suspend fun addPlaceToHistory(item: Card): Unit

   suspend fun getItemPlace(token: String ,id: String): ItemPlace

   suspend fun logout()

   suspend fun login()

   suspend fun getToken(): String

   suspend fun deleteHistory()
}