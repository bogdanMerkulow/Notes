package com.example.notes.common.repository

import com.example.notes.common.models.Note

interface NotesRepository {

    suspend fun getNotes(): List<Note>

    suspend fun editNote(note: Note)

    suspend fun removeNote(id: Long)

    suspend fun createNote(note: Note)
}