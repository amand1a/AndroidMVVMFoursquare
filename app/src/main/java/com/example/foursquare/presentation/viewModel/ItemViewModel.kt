package com.example.foursquare.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquare.domain.model.ItemPlace
import com.example.foursquare.domain.useCase.GetItemUseCase
import com.example.foursquare.domain.useCase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(private val getItemUseCase: GetItemUseCase,
    private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {

    private val _itemCard = MutableStateFlow<ItemPlace?>(null)

    val itemCard = _itemCard


    fun getItemCard(id: String){
        viewModelScope.launch {


            val getItemDeferred = async { getItemUseCase.invoke(id) }
            val getPhotosDeferred = async { getPhotosUseCase.invoke(id) }

            val item = getItemDeferred.await()
            val photos = getPhotosDeferred.await()

            _itemCard.value = item?.copy(images = photos)


        }
    }

}