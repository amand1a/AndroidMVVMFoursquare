package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val rep: Repository, private val getTokenUseCase: getTokenUseCase) {

    suspend operator fun invoke(id: String): ArrayList<String> {

        val token = getTokenUseCase()
        return rep.getItemPhotosFromApi( token,id)
    }
}