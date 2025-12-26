package com.hninhninwai.xyz.mycomposeapp.screens.note.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id = :noteId")
    fun getNoteById(noteId: Int): LiveData<Note?>

    @Update
    suspend fun update(note: Note)
}