package com.guifa.goodnews.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.guifa.goodnews.R;
import com.guifa.goodnews.adapter.NewsMainTabLayoutAdapter;
import com.guifa.goodnews.fragment.base.BaseFragment;

import butterknife.BindView;

/**
 * 底部首页
 */
public class NewsMainFragment extends BaseFragment {

    @BindView(R.id.newsMainTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.newsMainViewPager)
    ViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_main;
    }

    @Override
    public void initViews(View view) {
        initTabLayoutView(); // 初始化tabLayout
    }

    private void initTabLayoutView() {
        NewsMainTabLayoutAdapter adapter = new NewsMainTabLayoutAdapter(getFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
