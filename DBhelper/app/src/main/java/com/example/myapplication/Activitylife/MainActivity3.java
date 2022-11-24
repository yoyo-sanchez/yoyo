package com.example.myapplication.Activitylife;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity3 extends AppCompatActivity {
    private Button button;
    private Intent Intent;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("zt", "这是生命周期MainActivity3:onCreate");

        button = findViewById(R.id.jump4);
        Context context = this;
        Bundle bundle = new Bundle();
        textView = findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity4.class);
                //Bundle java用法
//                bundle.putInt("age2",20);
//                bundle.putString("name2","www");
//                intent.putExtra("userinfo",bundle);

//                startActivity(intent);f
                intent.putExtra("name", "zt");

//                startActivityForResult(intent, 1);

                test.launch(intent);//启动函数
            }
        });
    }

    public ActivityResultLauncher test = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 2) {
                        Log.d("zt", "onActivityResult 有返回值。。。");
                        TextView textView = findViewById(R.id.textView3);
                        textView.setText(result.getData().getStringExtra("result"));
                    }
                }
            }
    );


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable android.content.Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == 2) {
//            Log.d("zt", "onActivityResult");
//            textView.setText(data.getStringExtra("result"));
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("zt", "这是生命周期MainActivity3:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("zt", "这是生命周期MainActivity3:onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("zt", "这是生命周期MainActivity3:onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("zt", "这是生命周期MainActivity3:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("zt", "这是生命周期MainActivity3:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zt", "这是生命周期MainActivity3:onDestroy");
    }


}