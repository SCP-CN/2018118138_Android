package com.example.anotherreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private AnotherReceiver anotherReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.MY_BROADCAST");
        anotherReceiver = new AnotherReceiver();
        registerReceiver(anotherReceiver,intentFilter);
    }

    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(anotherReceiver);
    }

    class AnotherReceiver extends BroadcastReceiver{
        public void onReceive(Context context, Intent intent){
            Log.d("broadtest","test~");
            Toast.makeText(context,
                    "另一个广播接收器收到了！",Toast.LENGTH_SHORT).show();
        }
    }
}
