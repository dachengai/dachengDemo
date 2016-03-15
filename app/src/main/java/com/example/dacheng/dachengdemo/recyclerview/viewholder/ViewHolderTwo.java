package com.example.dacheng.dachengdemo.recyclerview.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.recyclerview.IFactory;
import com.example.dacheng.dachengdemo.recyclerview.data.RecyclerViewItemData;

/**
 * Created by dacheng on 16/3/10.
 */
public class ViewHolderTwo extends BaseViewHolder {


    public ViewHolderTwo(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindData(RecyclerViewItemData data)  {

    }

    public static class FactoryTwo implements IFactory{
        @Override
        public BaseViewHolder createItemView(Context context,ViewGroup parent) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_type_two, parent, false);
            return new ViewHolderTwo(context,itemView);
        }
    }
}
