package com.example.common.application

import com.example.common.activity.ActivityComponent
import com.example.common.activity.ActivityComponentBuilderModule
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    ActivityComponentBuilderModule::class,
])
interface ApplicationComponent {
    fun getActivityComponentBuilder(): ActivityComponent.Builder

    @Component.Builder
    interface Builder {
        fun addApplicationModule(module: ApplicationModule): Builder
        fun build(): ApplicationComponent
    }
}