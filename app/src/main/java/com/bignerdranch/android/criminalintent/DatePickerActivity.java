package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * Created by tonyk_000 on 12/1/2015.
 */
public class DatePickerActivity extends SingleFragmentActivity {

    public static final String EXTRA_DATE = "com.bignerdranch.android.criminalintent.date";

    public static Intent newIntent(Context packageContext, Date date){
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DATE, date);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new DatePickerFragment();
    }
}
