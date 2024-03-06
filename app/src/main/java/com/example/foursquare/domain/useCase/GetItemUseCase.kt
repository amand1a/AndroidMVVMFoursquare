package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import com.example.foursquare.domain.model.ItemPlace
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext


class GetItemUseCase @Inject constructor(private val rep: Repository ,
                                         private val  getTokenUseCase: getTokenUseCase) {


    suspend operator fun invoke(id: String): ItemPlace? {
        val token = getTokenUseCase()
        return rep.getItemPlace(token, id)

    }
}