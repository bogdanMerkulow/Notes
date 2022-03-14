package com.example.notes.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.common.models.Note
import com.example.notes.common.usecase.NotesUseCase
import com.example.notes.common.usecase.RouterUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class NoteCreateViewModel(
    private val notesUseCase: NotesUseCase
): ViewModel() {

    private val _noteCreated: MutableSharedFlow<Unit> = MutableSharedFlow()
    val noteCreated: SharedFlow<Unit> get() = _noteCreated.asSharedFlow()

    fun createNote(title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                title = title,
                content = content
            )

            notesUseCase.createNote(note)
            _noteCreated.emit(Unit)
        }
    }
}