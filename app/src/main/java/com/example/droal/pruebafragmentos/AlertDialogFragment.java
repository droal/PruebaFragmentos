package com.example.droal.pruebafragmentos;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class AlertDialogFragment extends DialogFragment {


    public AlertDialogFragment() {
        // Required empty public constructor
    }

    public static AlertDialogFragment getInstance(int string_resource_id){
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("title_id", string_resource_id);
        alertDialogFragment.setArguments(bundle);
        return alertDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher_round);

        builder.setTitle(getArguments().getInt("title_id"));

        builder.setPositiveButton(R.string.alert_dialog_fragment_positive_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getApplicationContext(), "You selected OK button", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        builder.setNegativeButton(R.string.alert_dialog_fragment_negative_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "You selected Cancel button", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        return builder.create();
    }

}
