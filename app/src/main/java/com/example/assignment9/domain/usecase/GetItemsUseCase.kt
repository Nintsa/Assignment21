package com.example.assignment9.domain.usecase

import com.example.assignment9.data.model.ItemInformation
import com.example.assignment9.domain.repository.ItemRepository

class GetItemsUseCase(private val repository: ItemRepository) {
    suspend operator fun invoke(): List<ItemInformation> {
        return repository.getItems()
    }
}