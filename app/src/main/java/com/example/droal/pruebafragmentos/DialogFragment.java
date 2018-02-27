package com.example.droal.pruebafragmentos;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment{

    private int styleId;

    public DialogFragment() {
        // Required empty public constructor
    }

    static DialogFragment newInstance(int styleId) {
        DialogFragment dialogFragment = new DialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("styleId", styleId);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        styleId = getArguments().getInt("styleId");

        // Pick a style based on the styleId.
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        switch (styleId) {
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
            case 3: style = DialogFragment.STYLE_NO_INPUT;
                new CountDownTimer(3000,100){

                    @Override
                    public void onTick(long millisUntilFinished) { }

                    @Override
                    public void onFinish() {
                        Toast.makeText(getActivity(), "count finish",Toast.LENGTH_SHORT).show();
                        dismiss(); }
                }.start();
            break;
            case 4: style = DialogFragment.STYLE_NORMAL; break;
            case 5: style = DialogFragment.STYLE_NORMAL; break;
            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
            case 8: style = DialogFragment.STYLE_NORMAL; break;
        }
        switch (styleId) {
            case 4: theme = android.R.style.Theme_Holo; break;
            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 6: theme = android.R.style.Theme_Holo_Light; break;
            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 8: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(style, theme);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().setTitle("TITLE HERE!");

        View v = inflater.inflate(R.layout.fragment_dialog, container, false);

        View tv = v.findViewById(R.id.frag_dialog_tv);
        ((TextView)tv).setText("Dialog type #: " + styleId );

        // Watch for button clicks.
        Button button = (Button)v.findViewById(R.id.frag_dialog_btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                //((FragmentDialog)getActivity()).showDialog();
                dismiss();
            }
        });


        return v;
    }

}
