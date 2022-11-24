package com.example.myapplication.Activitylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity4 extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Log.d("zt", "这是生命周期MainActivity4:onCreate");
//        Intent intent4 = getIntent();

//        Bundle bundle = intent4.getExtras().getBundle("userinfo");//获取


//        String str1 = bundle.getString("name2");
//        String str2 = bundle.getInt("age2") + " ";

        textView = findViewById(R.id.textView4black);
//        textView.setText(str1 + str2);
        button = findViewById(R.id.jump3);
        Context context = this;

        Intent intent4 = getIntent();
        String string = intent4.getStringExtra("name");
        intent4.putExtra("result", string + "年龄是20");
        setResult(2, intent4);
        finish();//结束MainActivity

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(context, MainActivity3.class);
//
//                startActivity(intent4);
//
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("zt", "这是生命周期MainActivity4:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("zt", "这是生命周期MainActivity4:onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("zt", "这是生命周期MainActivity4:onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("zt", "这是生命周期MainActivity4:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("zt", "这是生命周期MainActivity4:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zt", "这是生命周期MainActivity4:onDestroy");
    }


}