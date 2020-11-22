package com.example.asynctasktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int num = 0;

    MyTask mTask;

    Button download,cancel,add;
    TextView text,addText;
    ProgressBar progressBar; // 进度条

    private class MyTask extends AsyncTask<Void, Integer, Boolean> {

        // 执行 线程任务前的操作
        @Override
        protected void onPreExecute() {
            text.setText("加载中");
            progressBar.setProgress(0);
        }

        // 接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        //在子线程执行过程中打印出子线程和主线程的ID
        @Override
        protected Boolean doInBackground(Void... params) {
            Log.i("TaskTest", "当前线程id: "+Thread.currentThread().getId());
            Log.i("TaskTest", "主线程id: "+getMainLooper().getThread().getId());
            try {
                int count = 0;
                int length = 1;
                while (count<99) {

                    count += length;
                    // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
                    publishProgress(count);
                    // 模拟耗时任务
                    Thread.sleep(50);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        // 在主线程 显示线程任务执行的进度
        @Override
        protected void onProgressUpdate(Integer... progresses) {
            progressBar.setProgress(progresses[0]);
            text.setText("loading..." + progresses[0] + "%");
        }

        // 接收线程任务执行结果、将执行结果显示到UI组件
        @Override
        protected void onPostExecute(Boolean result) {
            // 执行完毕后，则更新UI
            text.setText("下载完毕");
            if(result){
                Log.d("TaskTest","success");
            }else{
                Log.d("TaskTest","false");
            }
        }

        // 将异步任务设置为：取消状态
        @Override
        protected void onCancelled() {
            text.setText("已取消");
            progressBar.setProgress(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 绑定UI组件
        setContentView(R.layout.activity_main);

        download = (Button) findViewById(R.id.download);
        cancel = (Button) findViewById(R.id.cancel);

        add = (Button) findViewById(R.id.add);
        addText = (TextView) findViewById(R.id.addText);

        text = (TextView) findViewById(R.id.text);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        // 加载按钮按按下时，则启动AsyncTask
        // 任务完成后更新TextView的文本
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mTask = new MyTask();
                    mTask.execute();
                }catch (Exception e){
                    Log.d("TaskTest",e.toString());
                }
            }
        });
        //取消按钮监听器设置
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取消一个正在执行的任务,onCancelled方法将会被调用
                mTask.cancel(true);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TaskTest", "当前线程id: "+Thread.currentThread().getId());
                try {
                    num = num + 1;
                    String string = Integer.toString(num);
                    addText.setText(string);
                }catch (Exception e){
                    Log.d("TaskTest",e.toString());
                }

            }
        });

    }

}


