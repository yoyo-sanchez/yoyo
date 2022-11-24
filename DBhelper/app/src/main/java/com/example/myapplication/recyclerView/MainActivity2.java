package com.example.myapplication.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Myadapter myadapter;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        list= Arrays.asList(new String[]{"A", "B", "C"});
        list = new ArrayList<String>();
        for (int i = 1; i < 9; i++) {
            list.add("这是第" + i + "个例子");
        }


        recyclerView = findViewById(R.id.recycl);

        myadapter = new Myadapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myadapter);


    }
}