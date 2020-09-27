package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+getTaskId()+this.toString());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //standard模式要用到的按钮形式
                //Intent intent = new Intent(FirstActivity.this,FirstActivity.class);

                //singleTop模式要用的按钮形式
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
    }
    public void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "你点击了添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击了删除", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
