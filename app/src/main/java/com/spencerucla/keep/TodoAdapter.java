package com.spencerucla.keep;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.spencerucla.keep.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spencers on 10/3/15.
 */
public class TodoAdapter extends ArrayAdapter<Todo> {
    public static final String TAG = "TodoAdapter";
    private List<Todo> mObjects;

    public TodoAdapter(Context context, int textViewResourceId, List<Todo> objects) {
        super(context, textViewResourceId, objects);
        mObjects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.reminder, parent, false);
        }

        Todo todo = mObjects.get(position);

        if (todo != null) {
            TextView textView = (TextView) view.findViewById(R.id.reminder_text);
            // TODO: date = reminder.getDate(); if (date == null) { display add_alert ImageButton; } else { display date; }
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.add_alert);

            ImageButton reorderButton = (ImageButton) view.findViewById(R.id.reorder);
            ImageButton addAlertButton = (ImageButton) view.findViewById(R.id.add_alert);
            reorderButton.setOnTouchListener(reorderListener);
            addAlertButton.setOnClickListener(addAlertListener);
            if (textView != null) {
                textView.setText(todo.getText());
            }
        }

        return view;
    }

    View.OnTouchListener reorderListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent motionEvent) {
            Log.d(TAG, "reorderListener");
            return true;
        }
    };

    View.OnClickListener addAlertListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "addAlertListener");
        }
    };
}
