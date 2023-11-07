package com.example.domain.models.main_response

data class MainResponseModel(
    val success: Boolean,
    val error: ErrorModel?,
    val time: String,
    val data: MainDataModel
)
