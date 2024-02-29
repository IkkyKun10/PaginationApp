package com.riezki.paginationapp.domain.repository

import androidx.paging.Pager
import com.riezki.paginationapp.data.local.entity.BeerEntity

interface BeerRepository {
    fun getBeersPaging() : Pager<Int, BeerEntity>
}