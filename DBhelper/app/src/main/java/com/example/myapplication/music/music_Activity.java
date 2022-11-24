package com.example.myapplication.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class music_Activity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5;
    private MyService.Mybinder mybinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        button1 = findViewById(R.id.music_button1);
        button2 = findViewById(R.id.music_button2);
        button3 = findViewById(R.id.music_button3);
//        button4 = findViewById(R.id.music_button4);
        button5 = findViewById(R.id.music_button5);
        Intent intent = new Intent(this, MyService.class);
        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("zt","onServiceConnected");
                mybinder = (MyService.Mybinder) iBinder;
                mybinder.myplay();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mybinder = null;
            }
        };
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
            }
        });
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bindService(intent, connection, Context.BIND_AUTO_CREATE);
//            }
//        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });
    }
}