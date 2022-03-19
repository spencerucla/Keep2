package com.spencerucla.keep;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.spencerucla.keep.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity {
    private static final String TAG = "TodoActivity";

    public static final String EXTRA_TODO_LIST = "extra_todo_list";

    private TodoListDao mTodoListDao;
    private ListView mListView;
    private List<Todo> mTodos = new ArrayList<>();
    private TodoAdapter mTodoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Intent intent = getIntent();
        int todoListId = -1;
        if (intent != null) {
            todoListId = intent.getIntExtra(EXTRA_TODO_LIST, -1);
        }
        Log.d(TAG, "extra id = " + todoListId);

        KeepDatabase database = KeepDatabase.getDatabase(getApplicationContext());
        mTodoListDao = database.todoListDao();

        /* FIXME
        if (todoListId >= 0) {
            mTodoList = TodoList.getInstance(todoListId);
        } else {
            mTodoList = new TodoList();
            //mTodoList.order = -1;
            //mTodoList.title = "";
            mTodoList.insert();
        }
        mTodos = mTodoList.getTodos();
        */

        mListView = (ListView) findViewById(R.id.list_todo);

        mTodoAdapter = new TodoAdapter(this, R.layout.reminder, mTodos);
        mListView.setAdapter(mTodoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.action_add_note:
                return true;
            case R.id.action_search:
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean addTodo(View view) {
        EditText editText = (EditText) findViewById(R.id.add_todo_edit_text);
        String text = editText.getText().toString();
        Log.d(TAG, "addTodo: " + text);

        /* FIXME
        Todo todo = new Todo();
        todo.setText(text);
        todo.insert();

        mTodos.add(todo);
        mTodoAdapter.notifyDataSetChanged();
        */

        editText.getText().clear();
        // TODO: then close keyboard?
        return true;
    }
}
