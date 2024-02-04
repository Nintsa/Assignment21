package com.example.assignment9.data.repository

import com.example.assignment9.data.model.ItemInformation
import com.example.assignment9.data.local.ItemDao
import com.example.assignment9.data.remote.ApiService
import com.example.assignment9.domain.repository.ItemRepository

class ItemRepositoryImpl(private val apiService: ApiService, private val itemDao: ItemDao): ItemRepository {
    override suspend fun getItems(): List<ItemInformation> {
        val items = apiService.getItems()
        itemDao.insertAll(items)
        return items
    }

    override suspend fun getItemsFromDatabase(): List<ItemInformation> {
        return itemDao.getItems()
    }
}