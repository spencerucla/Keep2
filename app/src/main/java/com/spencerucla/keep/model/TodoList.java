package com.spencerucla.keep.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = KeepDatabase.class)
public class TodoList extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    int order;

    @Column
    String title;

    // TODO: datetime for reminder

    List<Todo> todos; // or will this get auto-linked?

    // assumes it exists...
    public static TodoList getInstance(long id) {
        return SQLite.select()
                .from(TodoList.class)
                .where(TodoList_Table.id.eq(id))
                .querySingle();
    }

    // TODO: will it return empty list if none?
    public List<Todo> getTodos() {
        if (todos == null || todos.isEmpty()) {
            todos = SQLite.select()
                    .from(Todo.class)
                    .where(Todo_Table.todoList_id.eq(id))
                    .queryList();
        }
        return todos;
    }
}
