package com.example.thirdmissing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int flag = 0;//图片显示的flag

    private EditText editText;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button buttonChangeImage = (Button) findViewById(R.id.changeImage);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(this);
        buttonChangeImage.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button:
                Log.d("buttonTest","putoutButton");
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.changeImage:
                Log.d("buttonTest","changeButton");
                if (flag == 0){
                    imageView.setImageResource(R.drawable.img_2);
                    flag++;
                }
                else{
                    imageView.setImageResource(R.drawable.img_1);
                    flag--;
                }
                break;
            default:
                break;
        }
    }
    public void onBackPressed() {
        /*super.onBackPressed(); */   // 这一句要去掉，否则进入这个函数直接关App
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("注意!");
        dialog.setMessage("你确定要退出程序吗？");
        dialog.setCancelable(false);
        dialog.setPositiveButton("是",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();  // 关闭App
                    }
                });

        dialog.setNegativeButton("否",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        dialog.show();
    }
}
