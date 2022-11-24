package com.example.resolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver=getContentResolver();
        Button button=findViewById(R.id.button);

        ContentValues values=new ContentValues();
        values.put("name","myinsert");
        values.put("age",99);

        Uri uri=Uri.parse("content://test.provider2/student");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolver.insert(uri,values);

            }
        });
    }
}