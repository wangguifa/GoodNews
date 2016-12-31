package com.guifa.goodnews.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guifa.goodnews.R;

/**
 * 欢迎页面，启动图，闪屏页
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /**
         * 延迟启动，延迟3秒进入主页面
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
