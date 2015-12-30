package com.bignerdranch.android.criminalintent;

import java.text.DateFormat;
import java.util.UUID;
import java.util.Date;

/**
 * Created by tonyk_000 on 10/29/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;
    //adding field for contactId
    private long mContactId;

    //for chapter 8 challenge
    private DateFormat mDateFormat;

    public DateFormat getDateFormat() {
        return mDateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        mDateFormat = dateFormat;
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

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public long getContactId() {
        return mContactId;
    }

    public void setContactId(long contactId) {
        mContactId = contactId;
    }

    public Crime() {
        //need to return a crime with an appropriate UUID for the database
        this(UUID.randomUUID());
//        mId = UUID.randomUUID();
//        mDate = new Date();
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

}
