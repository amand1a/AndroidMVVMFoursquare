package com.example.foursquare.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.foursquare.domain.useCase.DeleteHistoryUseCase
import com.example.foursquare.domain.useCase.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ContainerViewModel @Inject constructor(private val logoutUseCase: LogoutUseCase , private val deleteHistoryUseCase: DeleteHistoryUseCase) : ViewModel() {


    suspend fun logout(){
        logoutUseCase()
        deleteHistoryUseCase()
    }
}