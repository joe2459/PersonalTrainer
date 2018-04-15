package com.bignerdranch.android.personaltrainer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewCustomersActivity extends AppCompatActivity {

    String name2;

    UserDBHelper mDatabaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcustomers);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new UserDBHelper(this);

        name2 = getIntent().getStringExtra("data");

        populateListView();
    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));

        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String name = adapterView.getItemAtPosition(i).toString();

            Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name
            int itemID = -1;
            while(data.moveToNext()){
                itemID = data.getInt(0);
            }
            if(itemID > -1){
                mDatabaseHelper.deleteName(itemID, name);
                Toast.makeText(ViewCustomersActivity.this, "Data successfully removed.", Toast.LENGTH_LONG).show();
                finish();
                Intent refresh = new Intent(ViewCustomersActivity.this, ViewCustomersActivity.class);
                refresh.putExtra("data",name2);
                startActivity(refresh);
            }
        }
        });
    }
    }

