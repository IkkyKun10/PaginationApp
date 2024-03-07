package com.riezki.paginationapp.domain.usecase

import androidx.paging.Pager
import com.riezki.paginationapp.data.local.entity.BeerEntity

interface BeerUseCase {
    operator fun invoke() : Pager<Int, BeerEntity>
}