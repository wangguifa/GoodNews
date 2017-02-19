package com.guifa.goodnews.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by wangguifa on 2016/12/31
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view); // 初始化注解
        initViews(view); // 初始化
        return view;
    }

    public abstract int getLayoutId(); // 获取布局

    public abstract void initViews(View view); // 初始化


    public void toast(String res) {
        Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT).show();
    }
}
