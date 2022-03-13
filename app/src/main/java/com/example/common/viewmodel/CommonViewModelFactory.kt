package com.example.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

class CommonViewModelFactory(
    private val viewModelsProviders: Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModelsProviders[modelClass]?.get() as? T ?:
        throw ClassNotFoundException("Зависимость ${modelClass.simpleName} не зарегистрирована.")
}