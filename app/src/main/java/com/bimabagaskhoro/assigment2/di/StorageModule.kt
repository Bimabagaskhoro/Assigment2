package com.bimabagaskhoro.assigment2.di

import android.content.Context
import com.bimabagaskhoro.assigment2.sf.AppSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) = AppSharedPreferences(context)

}