package com.example.datapassing_between_fragments_using_interface;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SecondFrag extends Fragment {

    SendData sendData;
    private Button button;
    private EditText e3,e4;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        e3 =view.findViewById(R.id.companyname);
        e4 = view.findViewById(R.id.designation);

        button = view.findViewById(R.id.b2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String company = e3.getText().toString();
                String designation = e4.getText().toString();

                sendData.sendCompanyDetails(company,designation);

            }
        });
        return view;
    }
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
                sendData = (SendData) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must Implement SendData... ");
        }
    }
}
