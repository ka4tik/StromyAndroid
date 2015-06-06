package com.example.ka4tik.stromy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by ka4tik on 6/6/15.
 */
public class AlertDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context=getActivity();
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Oops! Sorry!")
                .setMessage("There was an error. Please try again.")
                .setPositiveButton("Ok",null);
        return builder.create();
    }
}
