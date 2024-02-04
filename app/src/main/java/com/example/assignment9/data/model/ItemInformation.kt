package com.example.assignment9.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemInformation(
    @PrimaryKey
    val name: String,
    val imageSource: Int,
    val price: String,
    val type: String
)


