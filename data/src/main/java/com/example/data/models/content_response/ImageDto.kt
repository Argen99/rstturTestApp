package com.example.data.models.content_response

import com.example.data.utils.DataMapper
import com.example.domain.models.content_response.ImageModel

data class ImageDto(
    val sm: String,
    val md: String,
    val lg: String
) : DataMapper<ImageModel> {

    override fun toDomain() = ImageModel(
        sm = sm,
        md = md,
        lg = lg,
    )
}
