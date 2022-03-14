package com.example.notes.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.common.models.Note
import com.example.notes.common.usecase.NotesUseCase
import com.example.notes.common.usecase.RouterUseCase
import kotlinx.coroutines.launch

class NoteCreateViewModel(
    private val router: RouterUseCase,
    private val notesUseCase: NotesUseCase
): ViewModel() {

    fun navigateToListFragment() {
        viewModelScope.launch {
            router.listNotes()
        }
    }

    fun createNote(title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                title = title,
                content = content
            )

            notesUseCase.createNote(note)
        }
    }
}