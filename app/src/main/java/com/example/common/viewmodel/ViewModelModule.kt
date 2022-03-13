package com.example.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(
        viewModelProviders: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelProvider.Factory = CommonViewModelFactory(viewModelProviders)
}