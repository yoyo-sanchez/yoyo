package com.example.myapplication.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    private Mybinder binder;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music1);
        mediaPlayer.start();
        Log.d("zt", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("zt", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
        Log.d("zt", "onDestroy");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("zt", "onBind");
        binder = new Mybinder();
        return binder;
    }

    class Mybinder extends Binder {
        public void myplay() {
            mediaPlayer.start();
        }
    }

}