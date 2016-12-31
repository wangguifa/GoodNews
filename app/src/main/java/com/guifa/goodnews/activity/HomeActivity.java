package com.guifa.goodnews.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.guifa.goodnews.R;
import com.guifa.goodnews.bean.HomeBottomBean;
import com.guifa.goodnews.fragment.CareMainFragment;
import com.guifa.goodnews.fragment.MineMainFragment;
import com.guifa.goodnews.fragment.NewsMainFragment;
import com.guifa.goodnews.fragment.VideoMainFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class HomeActivity extends AppCompatActivity {
    // 底部TabLayout
    @BindView(R.id.tabLayout)
    CommonTabLayout tabLayout;
    // 标题
    private String[] mTitles = {"首页", "视频", "关注", "我的"};
    // 选中时图标
    private int[] mIconSelectIds = {R.drawable.bottom_home_select, R.drawable.bottom_video_select,
            R.drawable.bottom_care_select, R.drawable.bottom_mine_select};
    // 未选中时图标
    private int[] mIconUnSelectIds = {R.drawable.bottom_home_normal, R.drawable.bottom_video_normal,
            R.drawable.bottom_care_normal, R.drawable.bottom_mine_normal};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>(); // tab的数据
    private NewsMainFragment newsMainFragment;
    private VideoMainFragment videoMainFragment;
    private CareMainFragment careMainFragment;
    private MineMainFragment mineMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this); // 注解初始化
        initTab(); // 初始化tab
        initFragment(); // 初始化fragment
    }

    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new HomeBottomBean(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        newsMainFragment = new NewsMainFragment();
        videoMainFragment = new VideoMainFragment();
        careMainFragment = new CareMainFragment();
        mineMainFragment = new MineMainFragment();
        transaction.add(R.id.frameLayout, newsMainFragment, "newsMainFragment");
        transaction.add(R.id.frameLayout, videoMainFragment, "videoMainFragment");
        transaction.add(R.id.frameLayout, careMainFragment, "careMainFragment");
        transaction.add(R.id.frameLayout, mineMainFragment, "mineMainFragment");
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }

    /**
     * 切换fragment
     */
    private void SwitchTo(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0: // 首页
                transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                transaction.hide(mineMainFragment);
                transaction.show(newsMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 1: // 美女
                transaction.hide(newsMainFragment);
                transaction.hide(careMainFragment);
                transaction.hide(mineMainFragment);
                transaction.show(videoMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 2: // 视频
                transaction.hide(newsMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(mineMainFragment);
                transaction.show(careMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 3: // 关注
                transaction.hide(newsMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(mineMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }
}
