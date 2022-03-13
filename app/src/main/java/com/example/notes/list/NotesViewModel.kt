package com.example.notes.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.common.models.Note
import com.example.notes.common.repository.NotesRepository
import com.example.notes.common.usecase.NotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val noteUseCase: NotesUseCase,
    private val notesRepository: NotesRepository,
) : ViewModel() {

    private val _notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<Note>> get() = _notes

    fun loadNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val noteList = notesRepository.getNotes()

            _notes.tryEmit(noteList)
        }
    }

    fun onEditNote(id: Long) {
        Log.e(this.javaClass.name, "edit $id")
    }

    fun onRemoveNote(id: Long) {
        Log.e(this.javaClass.name, "remove $id")
    }

    fun onCreateNote() {
        noteUseCase.createNote()
    }

}