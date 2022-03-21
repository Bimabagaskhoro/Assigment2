package com.bimabagaskhoro.assigment2.di

import com.bimabagaskhoro.assigment2.data.ItemGuestRepository
import com.bimabagaskhoro.assigment2.domain.repository.IItemGuestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(tourismRepository: ItemGuestRepository): IItemGuestRepository

}