package com.guifa.goodnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guifa.goodnews.R;

import butterknife.ButterKnife;

/**
 * 底部我的页
 */
public class MineMainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_main, container, false);
        ButterKnife.bind(this,view); // 初始化注解
        return view;
    }
}
