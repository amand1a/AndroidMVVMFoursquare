package com.example.foursquare.data.api

import com.example.foursquare.data.api.model.cardPlaces.CardsApiModel
import com.example.foursquare.data.api.model.detailItemApi.DeatailItemApi
import com.example.foursquare.data.api.model.itemApi.PhotosItemApi
import com.example.foursquare.data.api.model.itemApi.PhotosItemApiItem
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {


    @GET("places/search?ll=53.9%2C27.588&radius=4000&limit=30")
   suspend fun getPlaces(@Header("Authorization") authorization: String): CardsApiModel

   @GET("places/{id}/photos")
   suspend fun getPhotosForId(@Header("Authorization") authorization: String, @Path("id") id: String): List<PhotosItemApiItem>


   @GET("places/{id}")
   suspend fun getDetailItem(@Header("Authorization") authorization: String, @Path("id") id: String): DeatailItemApi


}