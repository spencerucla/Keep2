package com.spencerucla.keep.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public int order;

    public String title;

    public String text;

    // TODO: datetime for reminder
}
