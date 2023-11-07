package com.example.data.models.main_response

import com.example.data.utils.DataMapper
import com.example.domain.models.main_response.TemplateModel
import com.google.gson.annotations.SerializedName

data class TemplateDto(
    val card: String,
    @SerializedName("object")
    val obj: String,
    val size: String,
    val direction: String
) : DataMapper<TemplateModel> {
    override fun toDomain() = TemplateModel(
        card = card,
        obj = obj,
        size = size,
        direction = direction
    )
}
