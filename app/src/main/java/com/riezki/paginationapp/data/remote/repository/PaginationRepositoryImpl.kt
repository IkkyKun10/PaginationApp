package com.riezki.paginationapp.data.remote.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.riezki.paginationapp.data.local.db.BeerDatabase
import com.riezki.paginationapp.data.local.entity.BeerEntity
import com.riezki.paginationapp.data.remote.service.BeerApi
import com.riezki.paginationapp.domain.repository.BeerRepository

class PaginationRepositoryImpl(
    private val beerDb: BeerDatabase,
    private val beerApi: BeerApi,
) : BeerRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getBeersPaging(): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(20),
            remoteMediator = BeerRemoteMediator(beerDb, beerApi),
            pagingSourceFactory = {
                beerDb.beerDao.pagingSource()
            }
        )
    }
}