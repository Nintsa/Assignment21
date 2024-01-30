package com.example.assignment9.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assignment9.data.model.ItemInformation

@Database(entities = [ItemInformation::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}