package com.example.notes.common.usecase

import com.example.notes.common.models.Note
import com.example.notes.common.repository.NotesRepository

class NotesUseCaseImpl(
    private val notesRepository: NotesRepository
): NotesUseCase {

    override suspend fun getNotes(): List<Note> =
        notesRepository.getNotes()

    override suspend fun createNote(note: Note) {
        notesRepository.createNote(note)
    }

    override suspend fun editNote(note: Note): Boolean {
        notesRepository.editNote(note)
        return true
    }

    override suspend fun removeNote(id: Long): Boolean {
        notesRepository.removeNote(id)
        return true
    }


}