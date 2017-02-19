package com.guifa.goodnews.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guifa.goodnews.R;
import com.guifa.goodnews.adapter.CareFragmentAdapter;
import com.guifa.goodnews.bean.CareBean;
import com.guifa.goodnews.constants.NetUrls;
import com.guifa.goodnews.fragment.base.BaseFragment;
import com.guifa.goodnews.http.NetRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Request;

/**
 * Created by GuiFa on 2017/2/11.
 * 新闻列表Fragment
 */
public class NewsFragment extends BaseFragment {

    @BindView(R.id.newsRecyclerView)
    RecyclerView mRecyclerView;

    public static final String ARGS_PAGE = "args_page";
    private String mPageTitle;
    private CareBean careBean;
    private CareFragmentAdapter mAdapter;

    public static NewsFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(ARGS_PAGE, title);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageTitle = getArguments().getString(ARGS_PAGE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void initViews(View view) {
        getArgumentFromSuper(); // 获取传值
        getDataFromNet(); // 初始化数据
        initRecycler(); // 初始化RecyclerView
    }

    /**
     * 获取传值
     */
    private void getArgumentFromSuper() {
        mPageTitle = getArguments().getString(ARGS_PAGE);
    }

    /**
     * 初始化数据
     */
    private void getDataFromNet() {
        Map<String, String> params = new HashMap<>();
        String url = NetUrls.BASE_URL + mPageTitle + "/" + 40 + "/" + 1;
        NetRequest.getRequest(url, params, new NetRequest.DataCallBack() {

            @Override
            public void requestSuccess(String result) throws Exception {
                if (!TextUtils.isEmpty(result)) {
                    careBean = new Gson().fromJson(result, CareBean.class);
                    mAdapter.setListDatas(careBean);
                }
            }

            @Override
            public void requestFailure(Request request, IOException e) {
                toast("获取数据失败");
            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecycler() {
        mAdapter = new CareFragmentAdapter(getActivity(), careBean);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
