package com.example.authencation_dangky.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.authencation_dangky.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("select * from note order by id DESC ")
    List<Note> getAllNote();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);
}
