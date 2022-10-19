package com.example.wechat;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wechat.databinding.ActivityChattingBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChattingActivity extends AppCompatActivity {

    private ActivityChattingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        binding = ActivityChattingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TextView title = findViewById(R.id.title);
        Intent intent = getIntent();
        String str_title = intent.getStringExtra("title");
        title.setText(str_title);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ChattingActivity.this, ResultActivity.class);
                test.launch(intent1);
            }
        });
    }

    public ActivityResultLauncher<Intent> test = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 2){

                        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
                        floatingActionButton.setBackgroundColor(Color.parseColor("#DAB649"));
                        String notice = result.getData().getStringExtra("result");
                        Toast.makeText(ChattingActivity.this,notice,Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("life", "activity2 is onPostResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life", "activity2 is onStart...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life", "activity2 is onReStart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life", "activity2 is onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life", "activity2 is onDestroy...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life", "activity2 is onPause...");
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("life", "activity2 is finish...");
    }

    @Override
    public void finishActivity(int requestCode) {
        super.finishActivity(requestCode);
        Log.d("life", "activity2 is finishActivity...");
    }
}