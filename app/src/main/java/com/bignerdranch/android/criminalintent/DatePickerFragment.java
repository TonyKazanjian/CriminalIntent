package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tonyk_000 on 11/28/2015.
 */
public class DatePickerFragment extends Fragment {

    private DatePickerFragmentListener mDatePickerFragmentListener;

    public static final String EXTRA_DATE = "com.bignerdranch.android.criminalintent.date";

    public static final String ARG_DATE = "date";

    private DatePicker mDatePicker;
    private Button mOKbutton;

//stashing the date into the DatePickerFragment's argument bundle, so CrimeFragment can tell DatePickerFragment which date to show
    public static DatePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try {
            mDatePickerFragmentListener = (DatePickerFragmentListener) activity;
            //casting is checking to see if the DatePickerFragmentListener is implemented by the context
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement DatePickerFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //extracting the date and initializing DatePicker
        Date date = (Date) getArguments().getSerializable(ARG_DATE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v = inflater.inflate(R.layout.dialog_date,container,false);
        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_date_picker);
        mDatePicker.init(year, month, day, null);

        mOKbutton = (Button) v.findViewById(R.id.OK_button);
        mOKbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = mDatePicker.getYear();
                int month = mDatePicker.getMonth();
                int day = mDatePicker.getDayOfMonth();
                Date date = new GregorianCalendar(year, month, day).getTime();
                mDatePickerFragmentListener.onOkayButtonClicked(date);
            }
        });

        return v;

    }

    //calling back to the target fragment
//    private void sendResult(int resultCode, Date date){
//        Intent intent = new Intent();
//        intent.putExtra(EXTRA_DATE, date);
//
//        //calls CrimeFragment.onActivityResult...
//        onActivityResult(CrimeFragment.REQUEST_DATE, resultCode, intent);
//
//        if (this.getTargetFragment() == null){
//            getActivity().setResult(resultCode, intent);
//        }
//    }

    public interface DatePickerFragmentListener{
        void onOkayButtonClicked(Date date);
    }
}
