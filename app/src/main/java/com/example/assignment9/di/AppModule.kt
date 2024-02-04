package com.example.assignment9.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.assignment9.Constants
import com.example.assignment9.MyApplication
import com.example.assignment9.data.local.ItemDao
import com.example.assignment9.data.local.ItemDatabase
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): ItemDatabase{
        return Room.databaseBuilder(
            context, ItemDatabase::class.java,
            Constants.itemDataBase
        ).build()
    }

    @Provides
    @Singleton
    fun provideItemDao(database: ItemDatabase) : ItemDao{
        return database.itemDao()
    }

    interface AppComponent : AndroidInjector<MyApplication> {
        @Component.Factory
        interface Factory : AndroidInjector.Factory<MyApplication>
    }
}