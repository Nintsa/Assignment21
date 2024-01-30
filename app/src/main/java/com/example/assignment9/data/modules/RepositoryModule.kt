package com.example.assignment9.data.modules

import com.example.assignment9.data.local.ItemDao
import com.example.assignment9.data.remote.ApiService
import com.example.assignment9.data.repository.ItemRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideItemRepository(apiService: ApiService, itemDao: ItemDao): ItemRepositoryImpl {
        return ItemRepositoryImpl(apiService, itemDao)
    }
}
