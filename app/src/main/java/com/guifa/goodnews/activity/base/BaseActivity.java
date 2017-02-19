package com.guifa.goodnews.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by wangguifa on 2017/2/19.
 */
public class BaseActivity extends AppCompatActivity {

    public void toast(String res) {
        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }
}
