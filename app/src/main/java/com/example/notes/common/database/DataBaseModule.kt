package com.example.notes.common.database

import android.content.Context
import androidx.room.Room
import com.example.common.activity.ActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [
    ActivityModule::class
])
class DataBaseModule {

    @Provides
    fun provideNoteDatabase(
        context: Context
    ): NoteDatabase = Room.databaseBuilder(
        context,
        NoteDatabase::class.java, "database-note.db"
    ).createFromAsset("database-note.db")
        .build()
}