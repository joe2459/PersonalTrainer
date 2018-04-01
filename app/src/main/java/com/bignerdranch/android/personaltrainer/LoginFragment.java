package com.bignerdranch.android.personaltrainer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class LoginFragment extends Fragment {

    private EditText et1;
    private TextView tv;
    private String name;
    private Login mName;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String data = getActivity().getIntent().getStringExtra("data");
        View inf = inflater.inflate(R.layout.fragment_login, container, false);
        TextView tv = (TextView) inf.findViewById(R.id.UserOutput);
        tv.setText("Logged in as: " + data);

        return inf;


    }

}
