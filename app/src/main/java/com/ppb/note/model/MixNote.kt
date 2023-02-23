package com.ppb.note.model


data class MixNote (
        val noteList: List<Note>?,
        val defaultNoteList: List<DefaultNote>?,
        val listNoteList: List<List<ListNote>>?
)