package com.example.notes.common.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notes.common.database.models.NoteDbo

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): Array<NoteDbo>?

    @Insert
    suspend fun insertAll(vararg notes: NoteDbo)

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun removeNote(id: Long)

    @Update(entity = NoteDbo::class)
    suspend fun updateNote(noteDbo: NoteDbo)
}