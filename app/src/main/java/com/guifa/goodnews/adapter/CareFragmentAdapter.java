package com.guifa.goodnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guifa.goodnews.R;
import com.guifa.goodnews.bean.CareBean;
import com.guifa.goodnews.bean.CareNewsBean;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.load;

/**
 * Created by GuiFa on 2017/2/15
 */

public class CareFragmentAdapter extends RecyclerView.Adapter<CareFragmentAdapter.MyViewHolder> {

    private Context mContext;
    private CareBean mDatas;

    public CareFragmentAdapter(Context context, CareBean datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public CareFragmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_care, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (mDatas != null) {
            List<String> images = mDatas.getResults().get(position).getImages();
            String imgUrl = "";
            if (images != null) {
                holder.iconImg.setVisibility(View.VISIBLE);
                imgUrl = images.get(0);
            } else {
                holder.iconImg.setVisibility(View.GONE);
            }
            if (imgUrl.toLowerCase().contains(".gif")) {
                Glide.with(mContext).load(imgUrl).asGif().into(holder.iconImg);
            } else {
                Glide.with(mContext).load(imgUrl).into(holder.iconImg);
            }
            holder.desStr.setText(mDatas.getResults().get(position).getDesc());
            if (mDatas.getResults().get(position).getWho() != null) {
                holder.author.setText(mDatas.getResults().get(position).getWho());
            }
        }
    }


    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.getResults().size() : 0;
    }

    public void setListDatas(CareBean careNewsBeanList) {
        this.mDatas = careNewsBeanList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImg;
        TextView desStr;
        TextView author;

        public MyViewHolder(View view) {
            super(view);
            iconImg = (ImageView) view.findViewById(R.id.iconImg);
            desStr = (TextView) view.findViewById(R.id.desStr);
            author = (TextView) view.findViewById(R.id.author);
        }
    }
}
