package com.example.foursquare.data.mapper

import com.example.foursquare.domain.ModelMapper
import com.example.foursquare.domain.model.Card
import javax.inject.Inject
import com.example.foursquare.data.api.model.cardPlaces.Result

class CardApiToCardMapper @Inject constructor(): ModelMapper<Result, Card> {


    override fun map(source:Result): Card {
        return  Card(
            id = source.fsq_id,
            imageUrl = source.categories[0].icon.prefix+"120"+source.categories[0].icon.suffix,
            namePlace = source.name,
            typePlace = source.categories[0].name
        )
    }
}