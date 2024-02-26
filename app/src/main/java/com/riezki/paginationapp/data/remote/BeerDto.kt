package com.riezki.paginationapp.data.remote

import com.squareup.moshi.Json

data class BeerDto(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "tagline")
    val tagline: String,

    @field:Json(name = "description")
    val description: String,

    @field:Json(name = "first_brewed")
    val firstBrewed: String,

    @field:Json(name = "image_url")
    val imageUrl: String?,
)
