package com.bimabagaskhoro.assigment2.ui.guests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bimabagaskhoro.assigment2.domain.usecase.ItemGuestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuestViewModel @Inject constructor(itemGuestUseCase: ItemGuestUseCase) : ViewModel() {
    val guest = itemGuestUseCase.getAllItemGuest().asLiveData()
}