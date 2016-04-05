package com.example.dacheng.dachengdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dacheng.dachengdemo.customview.CustomViewAct;
import com.example.dacheng.dachengdemo.dialog.DialogAct;
import com.example.dacheng.dachengdemo.qrcode.QRCodeAct;
import com.example.dacheng.dachengdemo.recyclerview.RecyclerViewAct;
import com.example.dacheng.dachengdemo.searchBar.SearchBarAct;
import com.example.dacheng.dachengdemo.searchBar.SearchViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mRecycler;
    private Button mDialog;
    private Button mSearchBar;
    private Button mQRCode;
    private Button mCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDialog = (Button) findViewById(R.id.act_dialog);
        mRecycler = (Button) findViewById(R.id.act_recyclerview);
        mSearchBar = (Button) findViewById(R.id.act_searchbar);
        mQRCode = (Button) findViewById(R.id.act_qrcode);
        mCustom = (Button) findViewById(R.id.act_customview);
        mDialog.setOnClickListener(this);
        mRecycler.setOnClickListener(this);
        mSearchBar.setOnClickListener(this);
        mQRCode.setOnClickListener(this);
        mCustom.setOnClickListener(this);
    }






    private void toAct(Class cls){
        Intent intent = new Intent(this,cls);
        this.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.act_dialog:
                toAct(DialogAct.class);
                break;
            case R.id.act_recyclerview:
                toAct(RecyclerViewAct.class);
                break;
            case R.id.act_searchbar:
                toAct(SearchViewActivity.class);
                break;
            case R.id.act_qrcode:
                toAct(QRCodeAct.class);
                break;
            case R.id.act_customview:
                toAct(CustomViewAct.class);
                break;
            default:
                break;
        }
    }
}
