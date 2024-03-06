package com.example.foursquare.di

import com.example.foursquare.data.api.model.cardPlaces.CardsApiModel
import com.example.foursquare.data.mapper.CardApiToCardMapper
import com.example.foursquare.domain.ModelMapper
import com.example.foursquare.domain.model.Card
import com.example.foursquare.data.api.model.cardPlaces.Result
import com.example.foursquare.data.api.model.detailItemApi.DeatailItemApi
import com.example.foursquare.data.api.model.itemApi.PhotosItemApiItem
import com.example.foursquare.data.database.models.Place
import com.example.foursquare.data.mapper.DetailItemMapper
import com.example.foursquare.data.mapper.PhotosApiToPhotosItem
import com.example.foursquare.data.mapper.PlaceToCard
import com.example.foursquare.domain.model.ItemPlace
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun getCardApiMapper(
        impl: CardApiToCardMapper
    ): ModelMapper<Result, Card>


    @Binds
    fun getPhotosMapper(
        impl: PhotosApiToPhotosItem
    ): ModelMapper<PhotosItemApiItem , String>


    @Binds
    fun getDetailItemMapper(
        impl: DetailItemMapper
    ): ModelMapper<DeatailItemApi, ItemPlace>


    @Binds
    fun getPlaceToCardMapper(impl:  PlaceToCard): ModelMapper<Place , Card>
}