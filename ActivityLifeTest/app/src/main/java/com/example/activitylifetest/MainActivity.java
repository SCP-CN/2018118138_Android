package com.example.activitylifetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "主活动";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
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
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
