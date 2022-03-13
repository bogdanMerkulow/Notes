package com.example.notes.common.repository

import com.example.notes.common.database.NoteDao
import com.example.notes.common.models.Note

class NotesRepositoryImpl(
    private val notesDao: NoteDao
): NotesRepository {

    override suspend fun getNotes(): List<Note> =
        notesDao.getNotes()?.map { Note(it.id, it.title, it.content) } ?: emptyList()

    override suspend fun editNote(id: Long) {

    }

    override suspend fun removeNote(id: Long) {

    }
}