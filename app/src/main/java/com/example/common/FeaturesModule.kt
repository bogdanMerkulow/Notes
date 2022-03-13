package com.example.common

import com.example.notes.NotesModule
import dagger.Module

@Module(includes = [
    NotesModule::class
])
class FeaturesModule