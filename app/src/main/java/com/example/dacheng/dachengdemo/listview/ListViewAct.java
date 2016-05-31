package com.example.dacheng.dachengdemo.listview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dacheng.dachengdemo.MainActivity;
import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.base.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dacheng on 16/5/26.
 */
public class ListViewAct extends BaseActivity {
    private ListView mListView; //首页的ListView
    private List<Brand> namesList; //用于装载数据的集合
    private Brand selectBrand; //用户选择的品牌
    private Button mSendBtn;//提交按钮
    private int mPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_listview);
        initView();
        initDatas();
    }

    private void initView(){
        mListView = (ListView)findViewById(R.id.id_myList);
        mSendBtn = (Button) findViewById(R.id.btn_send);
    }

    private void initDatas(){
        //初始化ListView适配器的数据
        namesList = new ArrayList<>();
        Brand brand0 = new Brand("apple");
        Brand brand1 = new Brand("sony");
        Brand brand2 = new Brand("xiaomi");
        Brand brand3 = new Brand("oppo");
        Brand brand4 = new Brand("meizu");

        brand2.setType(1);
        namesList.add(brand0);
        namesList.add(brand1);
        namesList.add(brand2);
        namesList.add(brand3);
        namesList.add(brand4);

        final MyAdapter myAdapter = new MyAdapter(this,namesList);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                mPosition = position;
                myAdapter.setSelectionPosition(position);
                myAdapter.notifyDataSetChanged();
            }
        });

        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(namesList.get(mPosition).getType() == 1){//有 editText
                    if(!TextUtils.isEmpty(myAdapter.getEditText())){
                        Toast.makeText(ListViewAct.this,"提交的editText内容为"+myAdapter.getEditText(),Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ListViewAct.this,"editText内容为空",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    selectBrand = namesList.get(mPosition);
                    Toast.makeText(ListViewAct.this,"您选中的手机品牌是："+selectBrand.getBandname(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

