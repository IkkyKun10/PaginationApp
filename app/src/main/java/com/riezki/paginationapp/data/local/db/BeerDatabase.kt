package com.riezki.paginationapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.riezki.paginationapp.data.local.entity.BeerEntity
import com.riezki.paginationapp.data.remote.service.BeerDao

@Database(
    entities = [BeerEntity::class],
    version = 1,
)
abstract class BeerDatabase : RoomDatabase() {
    abstract val beerDao: BeerDao
}