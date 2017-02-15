package com.guifa.goodnews.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guifa.goodnews.R;
import com.guifa.goodnews.adapter.CareFragmentAdapter;
import com.guifa.goodnews.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by GuiFa on 2017/2/15.
 * 关注页面
 */
public class CareFragment extends BaseFragment {

    @BindView(R.id.careRecyclerView)
    RecyclerView mRecyclerView;
    private static final String ARG_TITLE = "title";
    private String mTitle; // 标题
    private List<String> mData;
    private CareFragmentAdapter mAdapter;

    public static CareFragment newInstance(String title) {
        Bundle args = new Bundle();
        CareFragment fragment = new CareFragment();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_care;
    }

    @Override
    public void initViews(View view) {
        getArgumentFromSuper(); // 获取传值
        initData(); // 初始化数据
        initRecycler(); // 初始化RecyclerView
    }

    /**
     * 获取传值
     */
    private void getArgumentFromSuper() {
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mData = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mData.add(mTitle + (char) i);
        }
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecycler() {
        mAdapter = new CareFragmentAdapter(mRecyclerView.getContext(), mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
