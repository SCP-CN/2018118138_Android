package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent1 = new Intent(MainActivity.this, IntentActivity1.class);
                startActivity(intent1);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent("com.example.intenttest.ACTION_START");
                intent2.addCategory("com.example.intenttest.MY_CATEGORY");//添加自定义的category
                startActivity(intent2);
            }
        });

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent3);
            }
        });

        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String data = "你好，下一个活动~";
                Intent intent4 = new Intent(MainActivity.this,IntentActivity3.class);
                intent4.putExtra("extra_data",data);//第一个参数是取值时的key值
                startActivityForResult(intent4,1);//requestCode必须唯一值
            }
        });

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("extra_data",returnedData);
                }
                break;
            default:
        }
    }

}
