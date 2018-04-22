package com.bignerdranch.android.personaltrainer;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button nextButton;
    public EditText et1;

    private int STORAGE_PERMISSION_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nextButton = (Button) findViewById(R.id.SignInButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextActivity();
            }
        });



    }




    public void openNextActivity() {
        et1 = (EditText) findViewById(R.id.UserNameEditText);
        String str = et1.getText().toString();

        Intent intent = new Intent(this,ManageActivity.class);
        intent.putExtra("data",str); //data is a string variable holding some value.
        startActivity(intent);




    }
}
