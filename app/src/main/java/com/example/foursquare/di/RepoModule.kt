package com.example.foursquare.di

import com.example.foursquare.data.rep.PlacesRepositoryImpl
import com.example.foursquare.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun getRep(impl: PlacesRepositoryImpl) : Repository

}