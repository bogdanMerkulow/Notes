package com.example.notes

import androidx.lifecycle.ViewModel
import com.example.common.viewmodel.ViewModelKey
import com.example.notes.common.database.DataBaseModule
import com.example.notes.common.database.NoteDatabase
import com.example.notes.common.repository.NotesRepository
import com.example.notes.common.repository.NotesRepositoryImpl
import com.example.notes.common.router.RouterUseCaseImpl
import com.example.notes.common.usecase.NotesUseCase
import com.example.notes.common.usecase.NotesUseCaseImpl
import com.example.notes.common.usecase.RouterUseCase
import com.example.notes.create.NoteCreateViewModel
import com.example.notes.list.NotesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [
    DataBaseModule::class
])
class NotesModule {

    @Provides
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    fun provideNoteListViewModel(
        useCase: NotesUseCase,
        router: RouterUseCase
    ): ViewModel =
        NotesViewModel(
            useCase,
            router
        )

    @Provides
    @IntoMap
    @ViewModelKey(NoteCreateViewModel::class)
    fun provideNoteCreateViewModel(
        useCase: NotesUseCase
    ): ViewModel =
        NoteCreateViewModel(
            useCase
        )

    @Provides
    fun provideNoteUseCase(
        notesRepository: NotesRepository
    ): NotesUseCase =
        NotesUseCaseImpl(
            notesRepository
        )

    @Provides
    fun provideRouterUseCase(): RouterUseCase = RouterUseCaseImpl()

    @Provides
    fun provideNotesRepository(
        noteDatabase: NoteDatabase
    ): NotesRepository = NotesRepositoryImpl(noteDatabase.noteDao())
}