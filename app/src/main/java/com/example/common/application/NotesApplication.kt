package com.example.common.application

import android.app.Application

class NotesApplication : Application() {

    val applicationComponent: ApplicationComponent = DaggerApplicationComponent
        .builder()
        .addApplicationModule(ApplicationModule(this))
        .build()
}