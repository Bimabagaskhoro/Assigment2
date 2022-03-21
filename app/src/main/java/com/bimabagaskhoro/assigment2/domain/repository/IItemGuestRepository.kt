package com.bimabagaskhoro.assigment2.domain.repository

import com.bimabagaskhoro.assigment2.data.Resource
import com.bimabagaskhoro.assigment2.domain.model.ItemGuest
import kotlinx.coroutines.flow.Flow

interface IItemGuestRepository {
    fun getAllItemGuest(): Flow<Resource<List<ItemGuest>>>
}