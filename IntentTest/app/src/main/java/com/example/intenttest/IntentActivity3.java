package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IntentActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("extra_data",data);//第一个参数是过滤控制台输出的tag
    }

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return","你好，主活动");
        setResult(RESULT_OK,intent);
        finish();
    }
}
