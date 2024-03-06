package com.example.foursquare.data.mapper

import com.example.foursquare.data.database.models.Place
import com.example.foursquare.domain.ModelMapper
import com.example.foursquare.domain.model.Card
import javax.inject.Inject

class PlaceToCard @Inject constructor() : ModelMapper<Place , Card> {
    override fun map(source: Place): Card {
        return  Card(source.id , source.image , source.namePlace , source.typePlace)
    }


}