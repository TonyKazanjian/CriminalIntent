package com.bignerdranch.android.criminalintent;

import java.util.UUID;
import java.util.Date;

/**
 * Created by tonyk_000 on 10/29/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    private Date mDate;
    private boolean mSolved;

    public Crime() {
        //generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {


        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
