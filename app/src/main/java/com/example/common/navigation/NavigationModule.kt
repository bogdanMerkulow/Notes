package com.example.common.navigation

import android.app.Activity
import androidx.navigation.findNavController
import com.example.R
import com.example.common.activity.ActivityModule
import com.example.common.activity.ActivityScope
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
class NavigationModule {
    @ActivityScope
    @Provides
    fun provideNavControllerFactory(activity: Activity) =
        NavControllerFactory { activity.findNavController(R.id.nav_host_fragment) }
}