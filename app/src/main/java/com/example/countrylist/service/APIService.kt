package com.example.countrylist.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    companion object{
        val BASE_URL="https://restcountries.com/"//v3.1/all

        fun getData():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}