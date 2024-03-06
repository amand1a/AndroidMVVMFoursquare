package com.example.foursquare.data.rep

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.room.Dao
import androidx.room.Delete
import coil.map.Mapper
import com.example.foursquare.data.api.ApiService
import com.example.foursquare.data.api.model.cardPlaces.CardsApiModel
import com.example.foursquare.data.api.model.cardPlaces.Result
import com.example.foursquare.data.api.model.detailItemApi.DeatailItemApi
import com.example.foursquare.data.api.model.itemApi.PhotosItemApiItem
import com.example.foursquare.data.database.dao.CardDao
import com.example.foursquare.data.database.models.Place
import com.example.foursquare.data.mapper.CardApiToCardMapper
import com.example.foursquare.data.mapper.DetailItemMapper
import com.example.foursquare.domain.ModelMapper
import com.example.foursquare.domain.model.Card
import com.example.foursquare.domain.model.ItemPlace
import com.example.foursquare.domain.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class PlacesRepositoryImpl @Inject constructor(
    private val apiService: ApiService ,
    private val cardApiToCardMapper: ModelMapper<Result, Card>,
    private val photosMapper: ModelMapper<PhotosItemApiItem , String>,
    private val itemDetailItemMapper: ModelMapper<DeatailItemApi, ItemPlace>,
    private val dbDao: CardDao,
    private val placetoCardMapper: ModelMapper<Place , Card>,
    private val dataStore: DataStore<Preferences>):
    Repository {


    override  fun getPlacesHistoryFromStore(): Flow<List<Card>> {
        return dbDao.getItems().map { it.map { elem ->  placetoCardMapper.map(elem) } }
    }

    override suspend fun getPlacesAroundFromApi(token: String): ArrayList<Card> {
        return ArrayList( apiService.getPlaces(token).results.map {
             cardApiToCardMapper.map(it)
        })
    }

    override suspend fun getItemPhotosFromApi(token: String, id: String): ArrayList<String> {
        return ArrayList(apiService.getPhotosForId(token,id).map { photosMapper.map(it) })
    }

    override suspend fun addPlaceToHistory(card: Card) {
        dbDao.insertCard(Place(card.id ,card.imageUrl , card.namePlace , card.typePlace))
    }

    override suspend fun getItemPlace(token: String,id: String): ItemPlace {
        return   itemDetailItemMapper.map( apiService.getDetailItem(token,id))
    }


    override suspend fun logout() {
        dataStore.edit { it[TOKEN_KEY] = "" }
    }



    override suspend fun login() {
        dataStore.edit {
            it[TOKEN_KEY] = "fsq3udbE8/piqSr/ymBE054cTyrH/PCkAUtXENWU1dmLho8="
        }
    }

    override suspend fun getToken(): String {
        return dataStore.data.map{ it[TOKEN_KEY] ?: ""}.first()
    }

    override suspend fun deleteHistory() {
        dbDao.deleteAll()
    }


    private companion object{
            val TOKEN_KEY  = stringPreferencesKey("token_key")
    }

}