package com.bimabagaskhoro.assigment2.ui.event

import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.assigment2.domain.model.ItemEvent
import com.bimabagaskhoro.assigment2.utils.DataDummy
import javax.inject.Inject

class EventViewModel : ViewModel() {
    fun getMovie(): List<ItemEvent> = DataDummy.dataEvent()
}