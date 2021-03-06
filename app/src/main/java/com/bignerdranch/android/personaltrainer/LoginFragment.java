package com.bignerdranch.android.personaltrainer;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;


public class LoginFragment extends Fragment {

    private EditText et1;
    private TextView tv;
    private String name;
    private Login mName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


        String data = getActivity().getIntent().getStringExtra("data");

        //mPhotoFile =

        name = data;

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_off:
                //start dialog
                //Intent intent = new Intent(getActivity(), LoginActivity.class);
                AlertDialog.Builder logoff = new AlertDialog.Builder(getActivity());
                logoff.setMessage("Are you sure you want to log out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(),LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }) ;

                AlertDialog alert = logoff.create();
                alert.setTitle(R.string.logoff_title);
                alert.show();

                return(true);

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inf = inflater.inflate(R.layout.fragment_login, container, false);
        TextView tv = (TextView) inf.findViewById(R.id.UserOutput);
        tv.setText("Logged in as: " +  name);


        return inf;


    }




}
