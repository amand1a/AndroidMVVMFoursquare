package com.example.foursquare.di

import android.content.Context
import com.example.foursquare.data.database.AppDatabase
import com.example.foursquare.data.database.dao.CardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module

@InstallIn(SingletonComponent::class)
class DbModule {

 @Provides
 @Singleton
 fun getDatabase(@ApplicationContext context: Context):  AppDatabase {
     return AppDatabase.getDataBase(context)
 }


    @Provides
    fun provideDbDao(db: AppDatabase): CardDao {
        return db.PlaceDao()
    }
}