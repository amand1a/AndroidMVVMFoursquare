package com.example.foursquare.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foursquare.data.database.dao.CardDao
import com.example.foursquare.data.database.models.Place

@Database(entities = [Place::class] , version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun PlaceDao(): CardDao



    companion object{

        private val nameDb = "app_database"
        @Volatile
        private var Instance: AppDatabase? = null



        fun getDataBase(context: Context): AppDatabase {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context , AppDatabase::class.java , nameDb ).fallbackToDestructiveMigration().build().also { Instance = it }
            }
        }


    }
}