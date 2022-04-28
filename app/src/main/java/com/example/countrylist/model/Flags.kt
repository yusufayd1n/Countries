package com.example.countrylist.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Flags(
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String
)