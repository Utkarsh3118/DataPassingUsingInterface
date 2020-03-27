package com.example.datapassing_between_fragments_using_interface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SendData {

    public static FragmentManager fragmentManager;
    private UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDetails = new UserDetails();
        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, new FirstFrag(), null);
            fragmentTransaction.commit();
        }
    }
    Bundle bundle = new Bundle();//global bundle created
    @Override
    public void sendUsername(String username, String mail) {
        userDetails.setUsername(username);
        userDetails.setMail(mail);
        SecondFrag secondFrag = new SecondFrag();
        bundle.putString("username",username);
        bundle.putString("mail",mail);
        secondFrag.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,secondFrag,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void sendCompanyDetails(String company, String designation) {
        userDetails.setCompany(company);
        userDetails.setDesignation(designation);
        DisplayFrag displayFrag = new DisplayFrag();
        bundle.putString("company",company);
        bundle.putString("designation",designation);
        displayFrag.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,displayFrag,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
