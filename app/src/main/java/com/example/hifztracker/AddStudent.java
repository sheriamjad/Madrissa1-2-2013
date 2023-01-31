package com.example.hifztracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class AddStudent extends AppCompatActivity {

    EditText etxtName;
    EditText etxtSabak;
    EditText etxtSabki;
    EditText etxtManzil;
    EditText etxtDate;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        etxtName = findViewById(R.id.txtName);
        etxtSabak = findViewById(R.id.txtSabak);
        etxtSabki = findViewById(R.id.txtSabki);
        etxtManzil = findViewById(R.id.txtManzil);
        etxtDate = findViewById(R.id.selectDate);
        addButton = findViewById(R.id.btnAddStd);


        final Calendar calandar=Calendar.getInstance();
        final int year = calandar.get(Calendar.YEAR);
        final int month = calandar.get(Calendar.MONTH);
        final int day = calandar.get(Calendar.DAY_OF_MONTH);

        etxtDate.setOnClickListener(new View.OnClickListener() {
            //            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(AddStudent.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etxtDate.setText(date);
                    }
                },year,month,day);
                dialog.show();

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper db = new MyDBHelper(AddStudent.this);
                db.insertStudent(etxtName.getText().toString().trim(),etxtSabak.getText().toString().trim(),
                        etxtSabki.getText().toString().trim(),
                        etxtManzil.getText().toString().trim(),
                        etxtDate.getText().toString().trim());
            }
        });



    }
}