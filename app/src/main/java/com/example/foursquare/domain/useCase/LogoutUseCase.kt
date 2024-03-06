package com.example.foursquare.domain.useCase

import com.example.foursquare.domain.Repository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val rep: Repository) {

    suspend operator fun invoke(){
        rep.logout()
    }
}