package com.guifa.goodnews.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guifa.goodnews.R;

/**
 * 欢迎页面，启动图，闪屏页
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView imageView = (ImageView) findViewById(R.id.welcomeImg);
        Glide.with(WelcomeActivity.this).load("http://img.yxbao.com/news/image/201612/15/57c2c8d523.gif").asGif().into(imageView);

        /**
         * 延迟启动，延迟3秒进入主页面
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WelcomeActivity.this.finish();
                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
