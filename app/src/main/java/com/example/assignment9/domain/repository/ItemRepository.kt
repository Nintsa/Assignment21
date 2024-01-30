package com.example.assignment9.domain.repository

import com.example.assignment9.data.model.ItemInformation

interface ItemRepository {
    suspend fun getItems(): List<ItemInformation>
    suspend fun getItemsFromDatabase(): List<ItemInformation>
}