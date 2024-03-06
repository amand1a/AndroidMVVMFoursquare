package com.example.foursquare.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foursquare.data.database.models.Place
import kotlinx.coroutines.flow.Flow


@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(place: Place)


    @Query("Delete from places")
    suspend fun deleteAll()

    @Query("Select * from places")
    fun  getItems(): Flow<List<Place>>
}