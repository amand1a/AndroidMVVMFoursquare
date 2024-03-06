package com.example.foursquare.domain.useCase

import com.example.foursquare.data.database.models.Place
import com.example.foursquare.domain.Repository
import com.example.foursquare.domain.model.Card
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class getHistoryPlacesUseCase @Inject constructor(private val  repository: Repository) {

     operator fun invoke(): Flow<List<Card>> = repository.getPlacesHistoryFromStore()
}