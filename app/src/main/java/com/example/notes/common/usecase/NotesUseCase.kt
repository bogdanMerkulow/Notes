package com.example.notes.common.usecase

import com.example.notes.common.models.Note

interface NotesUseCase {

    suspend fun getNotes(): List<Note>

    suspend fun createNote(note: Note)

    suspend fun editNote(note: Note): Boolean

    suspend fun removeNote(id: Long): Boolean
}