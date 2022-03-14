package com.example.notes.common.database

import com.example.notes.common.database.models.NoteDbo
import com.example.notes.common.models.Note
import java.time.LocalDateTime

fun Note.toNoteDbo(createdAt: LocalDateTime): NoteDbo {
    return NoteDbo(
        id = this.id,
        title = this.title,
        content = this.content,
        createdAt = createdAt,
        modifiedAt = LocalDateTime.now()
    )
}