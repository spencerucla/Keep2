package com.example.spencers.keep2;

import java.util.Date;

/**
 * Created by spencers on 10/3/15.
 */
public class Reminder {
    private String mText = null;
    private Date mDate = null;

    public Reminder(String s) {
        mText = s;
    }

    public Reminder setDate(Date date) {
        mDate = date;
        return this;
    }

    public String getText() {
        return mText;
    }

    public Date getDate() {
        return mDate;
    }
}
