package com.example.dacheng.dachengdemo.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dacheng.dachengdemo.recyclerview.IFactory;
import com.example.dacheng.dachengdemo.recyclerview.ItemType;
import com.example.dacheng.dachengdemo.recyclerview.data.RecyclerViewItemData;
import com.example.dacheng.dachengdemo.recyclerview.viewholder.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by dacheng on 16/3/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ArrayList<RecyclerViewItemData> mDatas = new ArrayList<>();
    private Context mContext;
    public RecyclerViewAdapter(Context context){
        mContext = context;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        IFactory factory = ItemType.getFactoryByType(viewType);
        if(factory != null){
            viewHolder = factory.createItemView(mContext,parent);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindData(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public void setData( ArrayList<RecyclerViewItemData> datas){
        if(datas != null && datas.size() > 0){
            mDatas.clear();
            mDatas.addAll(datas);
            notifyDataSetChanged();
        }

    }
}
