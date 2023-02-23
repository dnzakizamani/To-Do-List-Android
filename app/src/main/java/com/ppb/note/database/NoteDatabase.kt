package com.ppb.note.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ppb.note.model.*


@Database(entities = [
    Note::class,
    DefaultNote::class,
    ListNote::class,
], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun defaultNoteDao(): DefaultNoteDao
    abstract fun listNoteDao(): ListNoteDao
}