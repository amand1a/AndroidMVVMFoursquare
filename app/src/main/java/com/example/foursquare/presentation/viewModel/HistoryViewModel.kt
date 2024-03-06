package com.example.foursquare.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquare.domain.model.Card
import com.example.foursquare.domain.useCase.getHistoryPlacesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val historyPlacesUseCase: getHistoryPlacesUseCase): ViewModel() {
    private val _cardList = MutableStateFlow<ArrayList<Card>>(arrayListOf())
    val cardList = _cardList



   val historyCards :  StateFlow<List<Card>>  = historyPlacesUseCase.invoke().stateIn(
       scope =  viewModelScope ,
       started = SharingStarted.WhileSubscribed(),
       initialValue = listOf()
   )

    fun getCardList(){
        viewModelScope.launch {
            delay(1000)
            val array = ArrayList<Card>()

            for (i in 1..20) {
                val card = Card(
                    id = i.toString(),
                    imageUrl = "image_$i",
                    namePlace = "Name $i",
                    typePlace = "Type $i"
                )
                array.add(card)
            }
            _cardList.value = array
        }
    }
}