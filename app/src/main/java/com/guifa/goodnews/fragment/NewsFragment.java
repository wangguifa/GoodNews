package com.guifa.goodnews.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guifa.goodnews.R;
import com.guifa.goodnews.fragment.base.BaseFragment;

/**
 * Created by GuiFa on 2017/2/11.
 * 新闻列表Fragment
 */
public class NewsFragment extends BaseFragment {

    public static final String ARGS_PAGE = "args_page";
    private int mPage;

    public static NewsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void initViews(View view) {
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("第" + mPage + "页");
    }
}
