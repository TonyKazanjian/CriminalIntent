package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by tonyk_000 on 12/31/2015.
 */
public class PictureDialogFragment extends DialogFragment {

    public static final String ARG_PICTURE = "picture";

    ImageView mPhoto;

    //stashing the photo into the PictureDialogFragment's argument bundle, so CrimeFragment can tell PictureDialogFragment which photo to show

    public static PictureDialogFragment newInstance(File photoFile){
        Bundle args = new Bundle();
        args.putSerializable(ARG_PICTURE, photoFile);

        PictureDialogFragment fragment = new PictureDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        //extracting the photo and initializing dialog
        File photo = (File) getArguments().getSerializable(ARG_PICTURE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        if (photo != null && photo.exists()) {
            Bitmap image = PictureUtils.getScaledBitmap(photo.getPath(), getActivity());
            mPhoto = (ImageView) v.findViewById(R.id.suspect_image);
            mPhoto.setImageBitmap(image);
        }

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }

}
