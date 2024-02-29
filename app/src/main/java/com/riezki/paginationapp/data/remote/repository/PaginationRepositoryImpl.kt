package com.riezki.paginationapp.data.remote.repository

import androidx.paging.Pager
import com.riezki.paginationapp.data.local.entity.BeerEntity
import com.riezki.paginationapp.domain.repository.BeerRepository

class PaginationRepositoryImpl : BeerRepository {
    override fun getBeersPaging(): Pager<Int, BeerEntity> {
        TODO("Not yet implemented")
    }
}