package com.example.countrylist.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CountryModelItem(
    @SerializedName("capital")
    val capital: List<String>,
    @SerializedName("cca2")
    val cca2: String,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("name")
    val name: Name,
    @SerializedName("population")
    val population: Int,
    @SerializedName("region")
    val region: String
)