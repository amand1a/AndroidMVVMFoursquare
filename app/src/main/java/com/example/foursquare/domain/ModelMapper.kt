package com.example.foursquare.domain

interface ModelMapper<T,S> {
    fun map(source: T): S
}