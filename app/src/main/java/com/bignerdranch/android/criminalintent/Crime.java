package com.bignerdranch.android.criminalintent;

import java.util.UUID;

/**
 * Created by tonyk_000 on 10/29/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        //generate unique identifier
        mId = UUID.randomUUID();
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
