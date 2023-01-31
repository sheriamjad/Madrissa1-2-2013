package com.example.hifztracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addBtn;
    MyDBHelper myDB;
    ArrayList<String> ids,names,sabak,sabki,manzil,date;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewDisplay);
        addBtn = findViewById(R.id.btnAdd);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , AddStudent.class);
                startActivity(intent);

            }
        });

        myDB = new MyDBHelper(MainActivity.this);
        ids = new ArrayList<>();
        names = new ArrayList<>();
        sabak = new ArrayList<>();
        sabki = new ArrayList<>();
        manzil = new ArrayList<>();
        date = new ArrayList<>();
        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,ids,names,sabak,sabki,manzil,date);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.getData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"No Data To Display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext()){
                ids.add(cursor.getString(0));
                names.add(cursor.getString(1));
                sabak.add(cursor.getString(2));
                sabki.add(cursor.getString(3));
                manzil.add(cursor.getString(4));
                date.add(cursor.getString(5));
            }
        }
    }
}