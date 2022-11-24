package com.example.myapplication.other;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class DataActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        TextView textView = findViewById(R.id.DatatextView);

        SharedPreferences sp1 = getSharedPreferences("ztSp", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp1.edit();
        editor.putString("name", "zt");
        editor.putInt("age", 19);
        editor.commit();


        String str1 = sp1.getString("name", "");
        String str2 = sp1.getInt("age", 1) + "";//默认值规定默认类型
//        sp1.getAll();
//        textView.setText(str1+str2);
        File file = getExternalFilesDir(null);
        String str3 = getFilesDir().toString();
        String str4 = getFilesDir().getParent();
        String str5 = getFilesDir().getName();
        String str6 = getFilesDir().getPath();
        //path=dir+filename目录加文件名
        File file1 = new File(getFilesDir() + "/zt.txt");

        String str7 = file1.getPath();
        Log.d("zt",str7);
        String str8 = " 今天有安卓开发\n xr上课";
        try {
            FileOutputStream fos = new FileOutputStream(file1);
            fos.write(str8.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File(file1.getPath());
//        File file2 = new File(String.valueOf(file1));
        Integer num = 3;
        String str10 = "";
        String str11 = "";
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file2);
            num = fis.read();
            InputStreamReader streamReader = new InputStreamReader(fis);
            str11 = streamReader.getEncoding();
            BufferedReader reader = new BufferedReader(streamReader);//缓冲区处理
            while ((str = reader.readLine()) != null) {
                str10 += str + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textView.setText(str11 + "\n" + str10);
    }
}