package com.example.myapplication.music;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECEIVE_SMS"}, 1);
        }

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView textView = findViewById(R.id.textView_main);
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> textView.setText(String.format("您已给出%s星", rating)));
//        Button button;
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction("android.zt.SMS_RECEIVED");
//                sendBroadcast(intent);
//            }
//        });

//        MyReceiver receiver =new MyReceiver();
//        Intent intent=new Intent();
//        receiver.onReceive(this,intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "未授权，无法实现预定的功能！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "请发一条短信验证...", Toast.LENGTH_SHORT).show();
                }
        }
    }


}