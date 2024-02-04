package com.example.assignment9.presentation

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment9.databinding.ItemCartBinding

class CartRecyclerAdapter(private val cartItems: MutableList<Item>) :
    RecyclerView.Adapter<CartRecyclerAdapter.CartViewHolder>() {

    inner class CartViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        // Bind your data to the views
        val currentItem = cartItems[position]
        // Example: holder.binding.textItemName.text = currentItem.name
    }

    // Add methods to update cart items, etc.
    fun updateItems(newItems: List<Item>) {
        cartItems.clear()
        cartItems.addAll(newItems)
        notifyDataSetChanged()
    }
}
