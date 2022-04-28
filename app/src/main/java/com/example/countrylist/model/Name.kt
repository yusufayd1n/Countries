package com.example.countrylist.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Name(
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String
)