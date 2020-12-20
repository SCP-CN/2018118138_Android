package com.example.dell.alarmalert;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.List;

public class AlarmAlert extends Activity {

    List<Clock> list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        int position = getIntent().getIntExtra("pos",-1);
        String s = getIntent().getStringExtra("content");
//        Log.d("test","" + position);

//        list = DataSupport.findAll(Clock.class);
//        Clock clock = list.get(position);
//        String ss = clock.content;
//        Log.d("test","getClock" + list.size());

        final Vibrator vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
        long[] patter = {1000,500,1000,500};
        vibrator.vibrate(patter,1);

        new AlertDialog.Builder(AlarmAlert.this)
                .setIcon(R.drawable.clock)
                .setTitle("闹钟响了")
                .setCancelable(false)
                .setMessage("时间到了！" + s)
                .setPositiveButton("关掉"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlarmAlert.this.finish();
                                vibrator.cancel();
                            }
                        }).show();

//        clock.setClockType(0);
//        Log.d("test","setType");

    }
}
