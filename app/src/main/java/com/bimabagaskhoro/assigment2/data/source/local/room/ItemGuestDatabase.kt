package com.bimabagaskhoro.assigment2.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bimabagaskhoro.assigment2.data.source.local.entity.ItemGuestEntity
import com.bimabagaskhoro.assigment2.data.source.local.room.ItemGuestDao

@Database(entities = [ItemGuestEntity::class], version = 1, exportSchema = false)
abstract class ItemGuestDatabase : RoomDatabase(){
    abstract fun tourismDao(): ItemGuestDao
}