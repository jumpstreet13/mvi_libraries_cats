package com.example.mvi_examples.mvilibraries

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val imageUrl: String,
    @SerializedName("width")
    val catName: String = "Tony"
)