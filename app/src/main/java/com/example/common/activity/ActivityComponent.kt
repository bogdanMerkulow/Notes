package com.example.common.activity

import androidx.lifecycle.ViewModelProvider
import com.example.common.FeaturesModule
import com.example.common.navigation.NavigationModule
import com.example.common.viewmodel.ViewModelModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [
    ActivityModule::class,
    NavigationModule::class,
    ViewModelModule::class,
    FeaturesModule::class
])
interface ActivityComponent {

    fun getViewModelFactory(): ViewModelProvider.Factory

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule): Builder
        fun build(): ActivityComponent
    }
}