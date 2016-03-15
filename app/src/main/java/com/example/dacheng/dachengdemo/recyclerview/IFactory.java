package com.example.dacheng.dachengdemo.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.example.dacheng.dachengdemo.recyclerview.viewholder.BaseViewHolder;

/**
 * Created by dacheng on 16/3/10.
 */
public interface IFactory {
    BaseViewHolder createItemView(Context context,ViewGroup parent);
}
