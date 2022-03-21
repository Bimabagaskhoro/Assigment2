package com.bimabagaskhoro.assigment2.domain.usecase

import com.bimabagaskhoro.assigment2.domain.repository.IItemGuestRepository
import javax.inject.Inject

class ItemGuestInteractor @Inject constructor(private val tourismGuestRepository: IItemGuestRepository):
    ItemGuestUseCase {

    override fun getAllItemGuest() = tourismGuestRepository.getAllItemGuest()

}