package com.guifa.goodnews.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

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
 * 底部视频页
 */
public class VideoMainFragment extends BaseFragment {

    @BindView(R.id.picRecyclerView)
    RecyclerView picRecyclerView;

    private String mPageTitle = "休息视频";
    private CareBean careBean;
    private CareFragmentAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video_main;
    }

    @Override
    public void initViews(View view) {
        initRecycler(); // 初始化RecyclerView
        getDataFromNet(); // 初始化数据
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecycler() {
        mAdapter = new CareFragmentAdapter(getActivity(), careBean);
        picRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 初始化数据
     */
    private void getDataFromNet() {
        Map<String, String> params = new HashMap<>();
        String url = NetUrls.BASE_URL + mPageTitle + "/" + 20 + "/" + 1;
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
}