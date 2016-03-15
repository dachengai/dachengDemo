package com.example.dacheng.dachengdemo.recyclerview.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dacheng.dachengdemo.recyclerview.data.RecyclerViewItemData;

/**
 * Created by dacheng on 16/3/10.
 *
 */
public abstract  class BaseViewHolder extends RecyclerView.ViewHolder {
    public Context mContext;

    public BaseViewHolder(Context context,View itemView) {
        super(itemView);
        mContext =  context;
        initView();
    }

   public abstract void initView();
   public abstract void bindData(RecyclerViewItemData data);
}
