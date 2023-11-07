package com.example.domain.models.content_response

data class ContentModel(
    val id: Int,
    val image: ImageModel,
    val title: String,
    val subtitle: String,
    val view: Int,
    val like: Int,
    val date: DateModel
)