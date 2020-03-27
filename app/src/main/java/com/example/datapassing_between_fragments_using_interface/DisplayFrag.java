package com.example.datapassing_between_fragments_using_interface;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFrag extends Fragment {


   private TextView t1,t2,t3,t4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        t1 =view.findViewById(R.id.tv_username);
        t2 = view.findViewById(R.id.tv_mail);
        t3 =view.findViewById(R.id.tv_companyname);
        t4 = view.findViewById(R.id.tv_designation);

        Bundle bundle = getArguments();

        String username = bundle.getString("username");
        String mail = bundle.getString("mail");
        String company = bundle.getString("company");
        String designation = bundle.getString("designation");

        t1.setText(username);
        t2.setText(mail);
        t3.setText(company);
        t4.setText(designation);

        return view;
    }

}
