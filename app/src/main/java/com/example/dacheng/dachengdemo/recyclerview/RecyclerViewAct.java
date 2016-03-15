package com.example.dacheng.dachengdemo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.recyclerview.adapter.RecyclerViewAdapter;

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
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mManager = new LinearLayoutManager(this);
        mManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mManager);
    }
}
