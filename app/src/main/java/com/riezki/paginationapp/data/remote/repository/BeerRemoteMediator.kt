package com.riezki.paginationapp.data.remote.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.riezki.paginationapp.data.local.db.BeerDatabase
import com.riezki.paginationapp.data.local.entity.BeerEntity
import com.riezki.paginationapp.data.mappers.toBeerEntity
import com.riezki.paginationapp.data.remote.service.BeerApi
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(
    private val beerDb: BeerDatabase,
    private val beerApi: BeerApi,
) : RemoteMediator<Int, BeerEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            delay(2.seconds)

            val beers = beerApi.getBeers(
                page = loadKey,
                pageCount = state.config.pageSize,
            )

            beerDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    beerDb.beerDao.clearAll()
                }

                val beerEntities = beers.map { it.toBeerEntity() }
                beerDb.beerDao.upsertAll(beerEntities)
            }
            
            return MediatorResult.Success(endOfPaginationReached = beers.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}