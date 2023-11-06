package com.example.domain.models

data class ErrorModel(
    val name: String,
    val status: String,
    val code: String,
    val message: String
)
