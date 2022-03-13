package com.example.notes

import androidx.lifecycle.ViewModel
import com.example.common.navigation.NavControllerFactory
import com.example.common.navigation.NavigationModule
import com.example.common.viewmodel.ViewModelKey
import com.example.notes.common.database.DataBaseModule
import com.example.notes.common.database.NoteDatabase
import com.example.notes.common.repository.NotesRepository
import com.example.notes.common.repository.NotesRepositoryImpl
import com.example.notes.common.router.RouterUseCaseImpl
import com.example.notes.common.usecase.NotesUseCase
import com.example.notes.common.usecase.NotesUseCaseImpl
import com.example.notes.common.usecase.RouterUseCase
import com.example.notes.list.NotesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [
    DataBaseModule::class,
    NavigationModule::class
])
class NotesModule {

    @Provides
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    fun provideNoteListViewModel(
        useCase: NotesUseCase,
        notesRepository: NotesRepository
    ): ViewModel =
        NotesViewModel(
            useCase,
            notesRepository
        )

    @Provides
    fun provideNoteUseCase(router: RouterUseCase): NotesUseCase =
        NotesUseCaseImpl(router)

    @Provides
    fun provideRouterUseCase(
        navControllerFactory: NavControllerFactory
    ): RouterUseCase = RouterUseCaseImpl(navControllerFactory)

    @Provides
    fun provideNotesRepository(
        noteDatabase: NoteDatabase
    ): NotesRepository = NotesRepositoryImpl(noteDatabase.noteDao())
}