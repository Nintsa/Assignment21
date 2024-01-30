package com.example.assignment9

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment9.data.model.ItemInformation
import com.example.assignment9.domain.repository.ItemRepository
import com.example.assignment9.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val cartViewModel: CartViewModel,
    private val itemRepository: ItemRepository
) : ViewModel() {

    val items: MutableLiveData<List<ItemInformation>> = MutableLiveData()

    fun getItems() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getItemsUseCase()
            items.postValue(result)
        }
    }

    fun getItemsFromDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            val items = itemRepository.getItemsFromDatabase()
            items.postValue(items)
        }
    }

    fun addToCart(item: ItemInformation) {
        cartViewModel.addItemToCart(item) // Delegate to CartViewModel
    }
}

class CartViewModel {

}
