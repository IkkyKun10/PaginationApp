package com.riezki.paginationapp.domain.usecase

import androidx.paging.Pager
import com.riezki.paginationapp.data.local.entity.BeerEntity
import com.riezki.paginationapp.domain.repository.BeerRepository

class BeerInteraction(
    private val repository: BeerRepository
) : BeerUseCase {
    override fun invoke(): Pager<Int, BeerEntity> {
        return repository.getBeersPaging()
    }
}