package com.example.notes.common.repository

import com.example.notes.common.database.NoteDao
import com.example.notes.common.database.models.NoteDbo
import com.example.notes.common.database.toNoteDbo
import com.example.notes.common.models.Note
import java.time.LocalDateTime

class NotesRepositoryImpl(
    private val notesDao: NoteDao
): NotesRepository {

    override suspend fun getNotes(): List<Note> =
        notesDao.getNotes()?.map { Note(it.id, it.title, it.content) } ?: emptyList()

    override suspend fun editNote(note: Note) {
        val noteDbo = notesDao.getNote(note.id)
        noteDbo?.let {
            notesDao.updateNote(note.toNoteDbo(it.createdAt))
        }
    }

    override suspend fun removeNote(id: Long) {
        notesDao.removeNote(id)
    }

    override suspend fun createNote(note: Note) {
        val noteDbo = NoteDbo(
            title = note.title,
            content = note.content,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        notesDao.insertAll(noteDbo)
    }
}