package com.hninhninwai.xyz.mycomposeapp.screens.note.repository

import androidx.lifecycle.LiveData
import com.hninhninwai.xyz.mycomposeapp.screens.note.roomdb.Note
import com.hninhninwai.xyz.mycomposeapp.screens.note.roomdb.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    val getAllNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) {
        return noteDao.insert(note)
    }

    fun getNoteById(noteId: Int): LiveData<Note?> {
        return noteDao.getNoteById(noteId)
    }

    suspend fun updateNote(note: Note) {
        return noteDao.update(note)
    }
}