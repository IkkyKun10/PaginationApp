package com.riezki.paginationapp.domain.model

data class Beers (
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String?,
)