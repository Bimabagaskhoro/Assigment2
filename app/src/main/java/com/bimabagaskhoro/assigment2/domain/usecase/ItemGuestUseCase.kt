package com.bimabagaskhoro.assigment2.domain.usecase

import com.bimabagaskhoro.assigment2.data.Resource
import com.bimabagaskhoro.assigment2.domain.model.ItemGuest
import kotlinx.coroutines.flow.Flow

interface ItemGuestUseCase {
    fun getAllItemGuest(): Flow<Resource<List<ItemGuest>>>
}