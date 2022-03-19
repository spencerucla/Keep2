package com.spencerucla.keep;

import androidx.room.Dao;

@Dao
public interface TodoListDao {
    // @Insert(onConflict = OnConflictStrategy.REPLACE)
    // void insert(TodoList todoList);

    // @Query("SELECT symbol FROM stocks_to_watch")
    // List<Todo> getTodos();

    // @Query("SELECT * FROM todo_lists WHERE id = :id")
    // LiveData<TodoList> get(long id);

    /*
    public static TodoList getInstance(long id) {
        return SQLite.select()
                .from(TodoList.class)
                .where(TodoList_Table.id.eq(id))
                .querySingle();
    }

    public List<Todo> getTodos() {
        if (todos == null || todos.isEmpty()) {
            todos = SQLite.select()
                    .from(Todo.class)
                    .where(Todo_Table.todoList_id.eq(id))
                    .queryList();
        }
        return todos;
    }
    */
}
