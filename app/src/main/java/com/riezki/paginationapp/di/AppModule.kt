package com.riezki.paginationapp.di

import android.app.Application
import androidx.room.Room
import com.riezki.paginationapp.data.local.db.BeerDatabase
import com.riezki.paginationapp.data.remote.repository.PaginationRepositoryImpl
import com.riezki.paginationapp.data.remote.service.BeerApi
import com.riezki.paginationapp.domain.repository.BeerRepository
import com.riezki.paginationapp.domain.usecase.BeerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: BeerRepository) : BeerUseCase {
        return BeerUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRepository(beerDb: BeerDatabase, beerApi: BeerApi) : BeerRepository {
        return PaginationRepositoryImpl(beerDb, beerApi)
    }

    @Provides
    @Singleton
    fun provideBeerDatabase(context: Application) : BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            "beers.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesBeerApi() : BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(BeerApi::class.java)
    }
}