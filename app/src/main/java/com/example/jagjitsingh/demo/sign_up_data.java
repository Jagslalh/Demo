package com.example.jagjitsingh.demo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sign_up_data extends SQLiteOpenHelper
{
    private final Context mycon;

    public sign_up_data(Context context) {
        super(context, "sig", null, 1);

        this.mycon=context;

    }



    @Override
    public void onCreate(SQLiteDatabase db)
    {
    String sql = "Create table sig(Id Int Auto Increment , organization text , first_name text , last_name text , email_id text , password text , mobile_no text , address text ,business text , country text , no_of_emp text)";
    db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)

    {
        db.execSQL("DROP TABLE  sig IF EXISTS");
        onCreate(db);

    }

    public boolean newinsert(String organization_name, String first_name, String last_name, String email_id, String password, String mobile_no, String address, String bussiness_type, String country, String no_of_employee)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues n = new ContentValues();
        n.put("Id",1);
        n.put("organization", organization_name);
        n.put("first_name", first_name);
        n.put("last_name", last_name);
        n.put("email_id", email_id);
        n.put("password", password);
        n.put("mobile_no", mobile_no);
        n.put("address", address);
        n.put("business", bussiness_type);
        n.put("country", country);
        n.put("no_of_emp", no_of_employee);
        long y =db.insert("sig", null, n);
        if (y == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor get(String Id,String organization_name, String first_name, String last_name, String email_id, String password, String mobile_no, String address, String bussiness_type, String country, String no_of_employee)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor d = db.rawQuery("Select * from sig",null);

        return d;
    }
}
