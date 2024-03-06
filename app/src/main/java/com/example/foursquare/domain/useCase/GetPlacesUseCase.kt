package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import com.example.foursquare.domain.model.Card
import javax.inject.Inject

class GetPlacesUseCase @Inject constructor(private val rep: Repository,private val getTokenUseCase: getTokenUseCase) {

    suspend operator fun invoke(): ArrayList<Card>? {
        val token = getTokenUseCase()
        return rep.getPlacesAroundFromApi(token)
    }
}