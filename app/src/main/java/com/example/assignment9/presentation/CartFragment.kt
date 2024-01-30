package com.example.assignment9.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment9.CartViewModel
import com.example.assignment9.databinding.FragmentCartBinding
import javax.inject.Inject

class CartFragment : BaseFragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    private lateinit var adapter: CartRecycleAdapter

    @Inject
    lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as MyApplication).appComponent.inject(this)

        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        adapter = CartRecycleAdapter(viewModel.cartItems.value ?: emptyList()) { cartItem ->
            showCartItemDialog(cartItem)
        }

        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter

        viewModel.cartItems.observe(viewLifecycleOwner, { cartItems ->
            if (cartItems.isNotEmpty()) {
                adapter.updateItems(cartItems)
            } else {
                binding.textEmptyCart.visibility = View.VISIBLE
            }
        })
        binding.btnPurchase.setOnClickListener {
            viewModel.clearCart()
            showToast("You Purchased all items")
        }

    }

    private fun showCartItemDialog(cartItem: CartItem) {
    }
}