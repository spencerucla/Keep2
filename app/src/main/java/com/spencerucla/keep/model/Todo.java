package com.spencerucla.keep.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = KeepDatabase.class)
public class Todo extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String text;

    @Column
    int order;

    // FIXME: android.database.sqlite.SQLiteException: table Todo has no column named todoList_id (code 1): , while compiling: INSERT INTO `Todo`(`text`,`order`,`todoList_id`) VALUES (?,?,?
    @ForeignKey
    TodoList todoList;

    public String getText() {
        return text;
    }

    public Todo setText(String t) {
        text = t;
        return this;
    }
}
