package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DatabaseActivity extends AppCompatActivity {

    private MyDBhelper dBhelper;
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        button1 = findViewById(R.id.dbbutton1);
        button2 = findViewById(R.id.dbbutton2);
        button3 = findViewById(R.id.dbbutton3);
        button4 = findViewById(R.id.dbbutton4);
        Log.d("zt", "DatabaseActivity onCreate");
        dBhelper = new MyDBhelper(this, "ztDB", null, 1);
        SQLiteDatabase database = dBhelper.getWritableDatabase(); 
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("zt", "button1");
                ContentValues values1 = new ContentValues();
                values1.put("name", "张三");
                values1.put("age", 16);
                ContentValues values2 = new ContentValues();
                values2.put("name", "李四");
                values2.put("age", 19);
                ContentValues values3 = new ContentValues();
                values3.put("name", "王五");
                values3.put("age", 18);
                database.insert("student", null, values1);
                database.insert("student", null, values2);
                database.insert("student", null, values3);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values1 = new ContentValues();
                values1.put("age", 25);
                database.update("student", values1, "name=?", new String[]{"李四"});
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.delete("student", "name=?", new String[]{"王五"});
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                database.execSQL("select * from student where name=张三");
                Cursor cursor1 = database.query("student", new String[]{"name"},
                        "name=?", new String[]{"张三"},
                        null, null, null);
                Log.d("zt", "cursor1.getCount:" + cursor1.getCount());
                Cursor cursor2 = database.rawQuery("select * from student where name=? or name=?", new String[]{"张三", "李四"});
                Cursor cursor3 = database.rawQuery("select * from student where name=? and age=?", new String[]{"张三", "20"});
                Log.d("zt", "cursor2.getCount:" + cursor2.getCount());
                Log.d("zt", "cursor2.getPosition:" + cursor2.getPosition());
                while (cursor2.moveToNext()) {
                    @SuppressLint("Range") Integer id = cursor2.getInt(cursor2.getColumnIndex("id"));
                    @SuppressLint("Range") String name=cursor2.getString(cursor2.getColumnIndex("name"));
                    Log.d("zt","res:"+id+"-"+name);
                }
                cursor2.close();
            }
        });
    }
}