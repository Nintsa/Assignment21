package com.example.assignment9.di

import com.example.assignment9.presentation.ItemsFragment
import dagger.Module

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeItemsFragment(): ItemsFragment
}