package com.riezki.paginationapp.data.mappers

import com.riezki.paginationapp.data.local.entity.BeerEntity
import com.riezki.paginationapp.data.remote.response.BeerDto
import com.riezki.paginationapp.domain.model.Beer

fun BeerDto.toBeerEntity() : BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl,
    )
}

fun BeerEntity.toBeerDomain() : Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl,
    )
}