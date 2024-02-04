package com.example.assignment9.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment9.data.model.ItemInformation

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    suspend fun getItems(): List<ItemInformation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ItemInformation>)
}