package com.ppb.note.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ppb.note.model.DefaultNote


@Dao
interface DefaultNoteDao {
    @Query("SELECT * FROM default_note WHERE note_id = :id")
    suspend fun get(id: Long): DefaultNote

    @Insert
    suspend fun insert(defaultNote: DefaultNote)

    @Update
    suspend fun update(defaultNote: DefaultNote)
}