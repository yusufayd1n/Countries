package com.example.countrylist.service

import com.example.countrylist.model.CountryModel
import com.example.countrylist.model.CountryModelItem
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("v3.1/all")
    fun getCountryList():Call<List<CountryModelItem>>
}