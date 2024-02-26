package com.riezki.paginationapp.data.mappers

import com.riezki.paginationapp.data.local.BeersEntity
import com.riezki.paginationapp.data.remote.BeerDto
import com.riezki.paginationapp.domain.model.Beers

fun BeerDto.toBeerEntity() : BeersEntity {
    return BeersEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl,
    )
}

fun BeersEntity.toBeerDomain() : Beers {
    return Beers(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl,
    )
}