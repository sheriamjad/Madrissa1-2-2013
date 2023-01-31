package com.example.hifztracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="StudentsDb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="students";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_SABAK="sabak";
    private static final String COLUMN_SABAKI="sabaki";
    private static final String COLUMN_MANZIL="manzil";
    private static final String COLUMN_DATE="date";




    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SABAK + " TEXT,"
                + COLUMN_SABAKI + " TEXT,"
                + COLUMN_MANZIL + " TEXT,"
                + COLUMN_DATE + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(String name,String sabak,String sabki,String manzil,String date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SABAK, sabak);
        values.put(COLUMN_SABAKI, sabki);
        values.put(COLUMN_MANZIL, manzil);
        values.put(COLUMN_DATE, date);

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        if(result==-1){
            Toast.makeText(context,"Failed To add",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(context,"Successfully added",Toast.LENGTH_SHORT).show();
    }

    Cursor getData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);

        }
        return cursor;
    }
}
