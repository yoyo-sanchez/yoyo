package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDBhelper extends SQLiteOpenHelper {
    public MyDBhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("zt","MyDBhelper is running...");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatebase) {
//        SQLiteDatabase sqLiteDatebase = null;
        sqLiteDatebase.execSQL("create table student(" +
                "id integer primary key autoincrement,name varchar,age integer)");
        Log.d("zt","MyDB_onCreate is running...");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
