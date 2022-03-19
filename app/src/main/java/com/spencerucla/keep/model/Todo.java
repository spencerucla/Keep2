package com.spencerucla.keep.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class Todo {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public int order;

    public String text;

    // @ForeignKey(entity = TodoList.class)
    // public long todoListId;
}
