package com.example.dacheng.dachengdemo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.recyclerview.adapter.RecyclerViewAdapter;
import com.example.dacheng.dachengdemo.recyclerview.data.RecyclerViewItemData;

import java.util.ArrayList;

/**
 * Created by dacheng on 16/3/15.
 */
public class RecyclerViewAct extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new RecyclerViewAdapter(this);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mManager = new LinearLayoutManager(this);
        mManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setAdapter(mAdapter);


        ArrayList<RecyclerViewItemData> mDatas = new ArrayList<>();
        for(int i = 0; i < 4 ; i ++ ){
            mDatas.add(new RecyclerViewItemData(i,"test","test"));
        }
        mAdapter.setData(mDatas);
    }
}
