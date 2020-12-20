package com.example.dell.alarmalert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class CallAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        int i = intent.getIntExtra("pos",-1);
        String s = intent.getStringExtra("content");
        Log.d("test","CallAlarm:" + s);

        Intent intent1 = new Intent(context,AlarmAlert.class);

        intent1.putExtra("content",s);
//        intent1.putExtra("pos",i);

        Bundle bundle = new Bundle();
        bundle.putString("STR_CALLER","");
        intent1.putExtras(bundle);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
