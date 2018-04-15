package com.bignerdranch.android.personaltrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewCustomerActivity extends AppCompatActivity {

    UserDBHelper userDB;

    Button btnAdd;
    EditText etName, etAge, etCreditCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcustomer);

        userDB = new UserDBHelper(this);

        etName = (EditText) findViewById(R.id.NameEditText);
        etAge = (EditText) findViewById(R.id.AgeEditText);
        etCreditCard = (EditText) findViewById(R.id.CreditCardEditText);

        btnAdd = (Button) findViewById(R.id.SubmitButton);

        AddData();

    }

    public void AddData() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String creditCard = etCreditCard.getText().toString();

                boolean insertData = userDB.addData(name, age, creditCard);

                if (insertData == true) {
                    Toast.makeText(NewCustomerActivity.this, "Data successfully inserted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewCustomerActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
