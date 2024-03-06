package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import com.example.foursquare.domain.model.Card
import javax.inject.Inject

class saveCardUseCase @Inject constructor(private val rep: Repository) {

    suspend operator fun invoke(item: Card) = rep.addPlaceToHistory(item)
}