package com.example.assignment9.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment9.ItemViewModel
import com.example.assignment9.ItemsRecycleAdapter
import com.example.assignment9.R
import com.example.assignment9.databinding.FragmentItemsBinding
import com.example.assignment9.domain.usecase.GetItemsUseCase
import javax.inject.Inject

// presentation/ui/items/ItemsFragment.kt
class ItemsFragment : BaseFragment() {

    private lateinit var binding: FragmentItemsBinding
    private lateinit var viewModel: ItemViewModel
    private lateinit var adapter: ItemsRecycleAdapter

    @Inject
    lateinit var getItemsUseCase: GetItemsUseCase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as MyApplication).appComponent.inject(this)

        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        adapter = ItemsRecycleAdapter(viewModel.items.value ?: mutableListOf())

        binding.itemsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.itemsRecycler.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner, { items ->
            if (items.isNotEmpty()) {
                adapter.updateItems(items)
            } else {
                showToast("No items found.")
            }
        })

        if (isNetworkAvailable()) {
            viewModel.getItems()
        } else {
            viewModel.getItemsFromDatabase()
        }
    }

    private fun isNetworkAvailable(): Boolean {
        return true
    }
}
