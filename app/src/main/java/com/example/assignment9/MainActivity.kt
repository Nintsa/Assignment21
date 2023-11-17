package com.example.assignment9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val clothes = mutableListOf<ItemInformation>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnBinding()
        itemsBinding()

    }

    private fun itemsBinding(){
        binding.itemsRecycler.layoutManager = LinearLayoutManager(this)
        binding.itemsRecycler.adapter = ItemsRecycleAdapter(clothes = clothes)
    }

    private fun btnBinding(){

    }


}