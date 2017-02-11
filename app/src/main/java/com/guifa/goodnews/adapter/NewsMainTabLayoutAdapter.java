package com.guifa.goodnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.guifa.goodnews.fragment.NewsFragment;

/**
 * Created by GuiFa on 2017/2/11.
 * 首页tabLayout的Adapter
 */
public class NewsMainTabLayoutAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"开源资讯", "推荐博客", "技术问答", "每日一博", "码云推荐"};

    public NewsMainTabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    /**
     * 获取标题
     *
     * @param position position
     * @return title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
