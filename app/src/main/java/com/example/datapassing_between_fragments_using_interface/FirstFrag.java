package com.example.datapassing_between_fragments_using_interface;


import android.app.Activity;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFrag extends Fragment {

    SendData sendData;
    private Button button;
    private EditText e1,e2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.b1);
        e1 = view.findViewById(R.id.username);
        e2 = view.findViewById(R.id.mail);

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               String username = e1.getText().toString();
               String mail = e2.getText().toString();
               sendData.sendUsername(username,mail);
            }
        }));
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity  activity = (Activity) context;
        try {
            sendData = (SendData) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must Implement SendData... ");
        }
    }
}
