package com.guifa.goodnews.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.guifa.goodnews.R;
import com.guifa.goodnews.adapter.CoordinatortablayoutAdapter;
import com.guifa.goodnews.fragment.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

/**
 * 底部关注页
 */
public class CareMainFragment extends BaseFragment {

    @BindView(R.id.coordinatortablayout)
    CoordinatorTabLayout mCoordinatortablayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private int[] mImageArray = new int[]{R.drawable.bg_android, R.drawable.bg_ios,
            R.drawable.bg_js, R.drawable.bg_other}; // CoordinatorTabLayout顶部图片
    private int[] mColorArray = new int[]{android.R.color.holo_blue_light, android.R.color.holo_red_light,
            android.R.color.holo_orange_light, android.R.color.holo_green_light}; // CoordinatorTabLayout顶部图片隐藏后切换显示的颜色
    private ArrayList<Fragment> mFragments; // fragmet数组
    private final String[] mTitles = {"Android", "iOS", "前端", "拓展资源"};

    @Override
    public int getLayoutId() {
        return R.layout.fragment_care_main;
    }

    @Override
    public void initViews(View view) {
        initFragments();
        initViewPager();
        initCoordinatorTabbLayout();
    }

    /**
     * 初始化fragment，有多少个页面创建多少个fragment
     */
    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(CareFragment.newInstance(title));
        }
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        mViewPager.setAdapter(new CoordinatortablayoutAdapter(getFragmentManager(), mFragments, mTitles));
    }

    /**
     * 初始化CoordinatorTabbLayout
     */
    private void initCoordinatorTabbLayout() {
        mCoordinatortablayout.setTitle("GoodNews").setBackEnable(true)
                .setImageArray(mImageArray, mColorArray).setupWithViewPager(mViewPager);
    }
}
