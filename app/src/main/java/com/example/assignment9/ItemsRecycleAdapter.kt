package com.example.assignment9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment9.databinding.ItemRecyclerviewBinding

class ItemsRecycleAdapter (private val clothes: MutableList<ItemInformation>) : RecyclerView.Adapter<ItemsRecycleAdapter.ItemsViewHolder>() {

    inner class ItemsViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return clothes.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
    }
}

