package com.example.jagjitsingh.demo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Data extends SQLiteOpenHelper
{
    private final Context mycon;
    public Data(Context context) {
        super(context, "jh", null, 1);
        this.mycon=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
String sql ="Create table io(email varChar , password varChar)";
        db.execSQL(sql);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
db.execSQL("DROP TABLE io IF EXISTS");
        onCreate(db);
    }

    public Boolean insert(String email, String password) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("email", email);
        c.put("password", password);
        long b = db.insert("io", null, c);
        if (b == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }



}
