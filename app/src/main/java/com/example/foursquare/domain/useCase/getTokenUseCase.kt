package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import javax.inject.Inject

class getTokenUseCase @Inject constructor( private val repository: Repository)   {

    suspend operator fun invoke() = repository.getToken()
}