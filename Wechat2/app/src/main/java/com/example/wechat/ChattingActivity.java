package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.wechat.databinding.ActivityChattingBinding;

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
    }
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