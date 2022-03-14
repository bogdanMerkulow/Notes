package com.example.notes.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.common.models.Note
import com.example.notes.common.usecase.NotesUseCase
import com.example.notes.common.usecase.RouterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val noteUseCase: NotesUseCase,
    private val router: RouterUseCase
) : ViewModel() {

    private val _notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<Note>> get() = _notes

    fun loadNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val noteList = noteUseCase.getNotes()
            _notes.tryEmit(noteList)
        }
    }

    fun onEditNote(note: Note) {
        viewModelScope.launch {
            val isEdited = noteUseCase.editNote(note)

            if (isEdited) {
                val notes = noteUseCase.getNotes()
                _notes.tryEmit(notes)
            }
        }
    }

    fun onRemoveNote(id: Long) {
        viewModelScope.launch {
            val isRemoved = noteUseCase.removeNote(id)

            if (isRemoved) {
                val notes = noteUseCase.getNotes()
                _notes.tryEmit(notes)
            }
        }
    }

    fun onCreateNote() {
        viewModelScope.launch {
            router.createNote()
        }
    }

}