package com.riezki.paginationapp.presenter.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.riezki.paginationapp.data.mappers.toBeerDomain
import com.riezki.paginationapp.domain.usecase.BeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    private val useCase: BeerUseCase
) : ViewModel() {

    val beerPagingFlow = useCase().flow
        .map { pagingData ->
            pagingData.map { it.toBeerDomain() }
        }
        .cachedIn(viewModelScope)
}