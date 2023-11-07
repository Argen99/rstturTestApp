package com.example.data.models.main_response

import com.example.data.utils.DataMapper
import com.example.domain.models.main_response.MainDataModel

data class MainDataDto(
    val buttons: List<ButtonDto>,
    val content: List<ContentInfoDto>
) : DataMapper<MainDataModel> {
    override fun toDomain() = MainDataModel(
        buttons = buttons.map { it.toDomain() },
        content = content.map { it.toDomain() }
    )
}
