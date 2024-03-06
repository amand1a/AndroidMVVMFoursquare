package com.example.foursquare.data.mapper

import com.example.foursquare.data.api.model.detailItemApi.DeatailItemApi
import com.example.foursquare.domain.ModelMapper
import com.example.foursquare.domain.model.ItemPlace
import javax.inject.Inject

class DetailItemMapper @Inject constructor() : ModelMapper<DeatailItemApi , ItemPlace>  {
    override fun map(source: DeatailItemApi): ItemPlace {
        return ItemPlace(id = source.fsq_id , images = arrayListOf() , beenHere = 2 ,
            categories = source.categories[0].name , contact = source.timezone , hereNow = 2 , location = source.location?.address ?: "-"  , name = source.name )
    }


}