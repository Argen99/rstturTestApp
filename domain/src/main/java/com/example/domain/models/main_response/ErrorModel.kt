package com.example.domain.models.main_response

data class ErrorModel(
    val name: String,
    val status: String,
    val code: String,
    val message: String
)
