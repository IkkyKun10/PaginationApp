package com.riezki.paginationapp.domain.usecase

import com.riezki.paginationapp.domain.repository.BeerRepository

class BeerUseCase(
    private val repository: BeerRepository
) {
    fun getBeersPaging() = repository.getBeersPaging()
}