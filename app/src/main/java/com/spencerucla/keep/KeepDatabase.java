package com.spencerucla.keep;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.spencerucla.keep.model.Note;
import com.spencerucla.keep.model.Todo;

@Database(entities = { Note.class, Todo.class }, version = 1)
public abstract class KeepDatabase extends RoomDatabase {

  public abstract TodoListDao todoListDao();

  private static KeepDatabase sInstance;

  static KeepDatabase getDatabase(Context context) {
    if (sInstance == null) {
      synchronized (KeepDatabase.class) {
        if (sInstance == null) {
          sInstance = Room.databaseBuilder(context.getApplicationContext(),
                  KeepDatabase.class, "keep_database")
                  .fallbackToDestructiveMigration()
                  .build();
        }
      }
    }
    return sInstance;
  }
}