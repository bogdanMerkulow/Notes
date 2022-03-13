package com.example.common.application

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: NotesApplication) {
    @Provides
    fun provideContext(): Context = application
}