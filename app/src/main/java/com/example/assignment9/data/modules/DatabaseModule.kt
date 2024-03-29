package com.example.assignment9.data.modules

import android.app.Application
import androidx.room.Room
import com.example.assignment9.data.local.ItemDao
import com.example.assignment9.data.local.ItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideItemDatabase(application: Application): ItemDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            ItemDatabase::class.java,
            "item_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideItemDao(database: ItemDatabase): ItemDao {
        return database.itemDao()
    }
}