package com.bignerdranch.android.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by tonyk_000 on 11/9/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.CrimeListListener, CrimeFragment.Callbacks {

    private static final String EXTRA_IS_SOLVED = "is solved";
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId(){
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null){
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }

    @Override
    public void onSolvedCheck(boolean isSolved, Crime crime) {
        if (findViewById(R.id.detail_fragment_container) != null){
            CrimeFragment crimeFragment = (CrimeFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.detail_fragment_container);
            crimeFragment.updateUI(isSolved);
        } else {
            CrimeFragment crimeFragment = CrimeFragment.newInstance(crime.getId());
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, crimeFragment)
//                    .commit();
            crimeFragment.updateUI(isSolved);
        }
    }
}
