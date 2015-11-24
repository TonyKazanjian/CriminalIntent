package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by tonyk_000 on 11/9/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
