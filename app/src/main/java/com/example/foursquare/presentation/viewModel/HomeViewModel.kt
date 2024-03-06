package com.example.foursquare.presentation.viewModel

import android.net.http.HttpException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquare.domain.model.Card
import com.example.foursquare.domain.useCase.GetPlacesUseCase
import com.example.foursquare.domain.useCase.saveCardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.http2.Http2
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlacesUseCase: GetPlacesUseCase,
    private val saveCardUseCase: saveCardUseCase
) : ViewModel() {
    private val _cardList = MutableStateFlow(arrayListOf<Card>())
    val cardList = _cardList


    fun getUser() {

       viewModelScope.launch {

           try {
               val cards = getPlacesUseCase.invoke()
               _cardList.value = cards ?: arrayListOf()
           }
           catch (e: Exception){
               _cardList.value = arrayListOf()
           }


       }
    }

    fun saveUser(item: Card){
        viewModelScope.launch {
            saveCardUseCase(item)
        }
    }
}