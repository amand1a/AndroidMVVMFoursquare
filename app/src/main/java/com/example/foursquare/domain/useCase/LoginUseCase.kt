package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(){
        repository.login()
    }


}