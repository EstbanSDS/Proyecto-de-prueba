package com.example.prueba.doglist

import com.google.gson.annotations.SerializedName

class DogsResponse (
 @SerializedName("status") val status: String,
 @SerializedName("message") val images: List<String>
)