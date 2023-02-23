package com.ppb.note.database

import androidx.room.*
import com.ppb.note.model.ListNote


@Dao
interface ListNoteDao {
    @Query("SELECT * FROM list_note WHERE note_id = :id ")
    suspend fun getAll(id: Long): List<ListNote>

    @Insert
    suspend fun insert(listNote: List<ListNote>)
}