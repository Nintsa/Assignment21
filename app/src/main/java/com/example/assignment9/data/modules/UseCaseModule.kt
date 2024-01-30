package com.example.assignment9.data.modules

import com.example.assignment9.domain.repository.ItemRepository
import com.example.assignment9.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetItemsUseCase(repository: ItemRepository): GetItemsUseCase {
        return GetItemsUseCase(repository)
    }
}