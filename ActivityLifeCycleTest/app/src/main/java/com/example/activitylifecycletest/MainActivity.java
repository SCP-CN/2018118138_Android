package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestory");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
