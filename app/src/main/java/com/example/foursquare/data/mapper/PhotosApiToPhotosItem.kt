package com.example.foursquare.data.mapper

import com.example.foursquare.data.api.model.itemApi.PhotosItemApiItem
import com.example.foursquare.domain.ModelMapper
import javax.inject.Inject

class PhotosApiToPhotosItem @Inject constructor() : ModelMapper<PhotosItemApiItem, String> {
    override fun map(source: PhotosItemApiItem): String {
        return source.prefix + "original"+source.suffix
    }
}