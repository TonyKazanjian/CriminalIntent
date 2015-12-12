package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * Created by tonyk_000 on 12/1/2015.
 */
public class DatePickerActivity extends SingleFragmentActivity implements DatePickerFragment.DatePickerFragmentListener{


    @Override
    protected Fragment createFragment() {
        return new DatePickerFragment().newInstance(new Date());
    }

    @Override
    public void onOkayButtonClicked(Date date) {

        Intent intent = new Intent();
        intent.putExtra(DatePickerFragment.EXTRA_DATE,date);

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
