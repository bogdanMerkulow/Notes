package com.example.notes.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.navigation.NavCommand
import com.example.notes.common.models.Note
import com.example.notes.common.usecase.NotesUseCase
import com.example.notes.common.usecase.RouterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NotesViewModel(
    private val noteUseCase: NotesUseCase,
    private val router: RouterUseCase
) : ViewModel() {

    private val _notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<Note>> get() = _notes

    private val _navigate: MutableSharedFlow<NavCommand> = MutableSharedFlow()
    val navigate: SharedFlow<NavCommand> get() = _navigate.asSharedFlow()

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
            val navCommand = router.createNoteNavCommand()
            _navigate.emit(navCommand)
        }
    }

}