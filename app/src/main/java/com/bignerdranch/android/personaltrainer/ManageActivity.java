package com.bignerdranch.android.personaltrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManageActivity extends AppCompatActivity {

    private Button newCustomerButton;
    private Button viewCustomerButton;
    private Button newSessionButton;
    private Button viewSessionsButton;
    public TextView tv;
    public String name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        newCustomerButton = (Button) findViewById(R.id.NewCustomerButton);
        newCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewCustomerActivity();
            }
        });

        viewCustomerButton = (Button) findViewById(R.id.ViewCustomerButton);
        viewCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewCustomerActivity();
            }
        });

        newSessionButton = (Button) findViewById(R.id.NewSessionButton);
        newSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewSessionActivity();
            }
        });

        viewSessionsButton = (Button) findViewById(R.id.UpcomingSessionsButton);
        viewSessionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewSessionActivity();

            }
        });



    }

    public interface OnCallbackReceived {
        public void Update();
    }

    public void openNewCustomerActivity() {
        Intent intent = new Intent(this,NewCustomerActivity.class);
        startActivity(intent);

    }

    public void openViewCustomerActivity() {
        Intent intent = new Intent(this,ViewCustomersActivity.class);
        startActivity(intent);
    }
    public void openNewSessionActivity() {
        Intent intent = new Intent(this,NewSessionActivity.class);
        startActivity(intent);
    }
    public void openViewSessionActivity() {
        Intent intent = new Intent(this,ViewSessionsActivity.class);
        startActivity(intent);
    }
}