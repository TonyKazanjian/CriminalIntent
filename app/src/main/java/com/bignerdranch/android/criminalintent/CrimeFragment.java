package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

/**
 * Created by tonyk_000 on 10/29/2015.
 */
public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final String DIALOG_TIME = "DialogTime";

    public static final int REQUEST_DATE = 0;
    private static final int REQUEST_TIME = 0;

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private Button mTimeButton;
    private CheckBox mSolvedCheckbox;

    private DateFormat mDateFormat;
    private Date mRawDate;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_crime,container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This space intnetionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This one too
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
//        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), DatePickerActivity.class);
                i.putExtra(DatePickerFragment.EXTRA_DATE, mCrime.getDate());
                getActivity().startActivityForResult(i, REQUEST_DATE);
            }
        });

//        mTimeButton = (Button) v.findViewById(R.id.crime_time);
//        updateTime();
//        mTimeButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                FragmentManager manager = getFragmentManager();
//                TimePickerFragment dialog = TimePickerFragment.newInstance(mCrime.getDate());
//                dialog.setTargetFragment(CrimeFragment.this,REQUEST_TIME);
//                dialog.show(manager, DIALOG_TIME);
//
//            }
//        });

        mSolvedCheckbox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckbox.setChecked(mCrime.isSolved());
        mSolvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

    //retrieving date extra from DatePickerFragment, setting the date on Crime, and refreshing the text on the date button
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }

        if (requestCode == REQUEST_DATE){
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mCrime.setDate(date);

            updateDate();
        }

//        if (requestCode == REQUEST_TIME){
//            Date date = (Date) data.getSerializableExtra(TimePickerFragment.EXTRA_TIME);
//            mCrime.setDate(date);
//            updateTime();
//        }
    }

    public void updateDate() {
        Date date = (Date)getActivity().getIntent().getSerializableExtra(DatePickerFragment.EXTRA_DATE);
//        mDateFormat = new DateFormat();
//        mDateFormat.getDateFormat(getActivity());
        mDateButton.setText(date.toString());
//        mDateButton.setText(mDateFormat.format("EEEE, LLLL d, yyyy", mRawDate));
    }

    public void passDate(Date date){
        if (mCrime != null){
            mCrime.setDate(date);
        }
    }

//    private void updateTime() {
//        mRawDate = mCrime.getDate();
//        mDateFormat = new DateFormat();
//        mDateFormat.getDateFormat(getActivity());
//        mTimeButton.setText(mCrime.getDate().toString());
//        mTimeButton.setText(mDateFormat.format("k:m a", mRawDate));
//    }

}


