package com.example.notes.common.usecase

interface NotesUseCase {
    fun createNote()
    fun editNote(id: Long)
    fun removeNote(id: Long)
}