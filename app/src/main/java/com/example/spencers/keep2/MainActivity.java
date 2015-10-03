package com.example.spencers.keep2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Keep MainActivity";
    private ListView listView;
    // TODO: make persistent
    private ArrayList<Reminder> mReminders = new ArrayList<Reminder>();
    ReminderAdapter mReminderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        listView = (ListView) findViewById(R.id.list_todo);

        mReminderAdapter = new ReminderAdapter(getApplicationContext(),
                R.layout.reminder, mReminders);
        listView.setAdapter(mReminderAdapter);
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

    public boolean addReminder(View view) {
        EditText editText = (EditText) findViewById(R.id.add_todo_edit_text);
        // TODO: use CalendarContract.Reminders
        Reminder reminder = new Reminder(editText.getText().toString());
        mReminders.add(reminder);
        Log.d(TAG, "add reminder: " + reminder.getText());
        mReminderAdapter.notifyDataSetChanged();
        editText.getText().clear();
        // TODO: then close keyboard?
        return true;
    }
}
