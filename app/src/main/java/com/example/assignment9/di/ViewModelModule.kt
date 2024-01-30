package com.example.assignment9.di

import androidx.lifecycle.ViewModel
import com.example.assignment9.ItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ItemViewModel::class)
    abstract fun bindItemViewModel(viewModel: ItemViewModel): ViewModel
}