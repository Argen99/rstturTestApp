package com.example.data.models

import com.google.gson.annotations.SerializedName

data class TemplateDto(
    val card: String,
    @SerializedName("object")
    val obj: String,
    val size: String,
    val direction: String
)
