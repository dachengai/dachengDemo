package com.example.dacheng.dachengdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dacheng.dachengdemo.Utils.DemoConst;
import com.example.dacheng.dachengdemo.base.image.picasso.ImageAct;
import com.example.dacheng.dachengdemo.customview.CustomAct;
import com.example.dacheng.dachengdemo.customview.progress.ProgressAct;
import com.example.dacheng.dachengdemo.dialog.DialogAct;
import com.example.dacheng.dachengdemo.mvp.login.LoginActivity;
import com.example.dacheng.dachengdemo.qrcode.QRCodeAct;
import com.example.dacheng.dachengdemo.recyclerview.RecyclerViewAct;
import com.example.dacheng.dachengdemo.searchBar.SearchViewActivity;
import com.example.dacheng.dachengdemo.service.ServiceAct;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mRecycler;
    private Button mDialog;
    private Button mSearchBar;
    private Button mQRCode;
    private Button mCustom;
    private Button mImage;
    private Button mLogin ;
    private Button mService ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDialog = (Button) findViewById(R.id.act_dialog);
        mRecycler = (Button) findViewById(R.id.act_recyclerview);
        mSearchBar = (Button) findViewById(R.id.act_searchbar);
        mQRCode = (Button) findViewById(R.id.act_qrcode);
        mCustom = (Button) findViewById(R.id.act_customview);
        mImage = (Button) findViewById(R.id.act_image);
        mLogin = (Button) findViewById(R.id.act_login);
        mDialog.setOnClickListener(this);
        mRecycler.setOnClickListener(this);
        mSearchBar.setOnClickListener(this);
        mQRCode.setOnClickListener(this);
        mCustom.setOnClickListener(this);
        mImage.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mService = (Button) findViewById(R.id.act_service);
        mService.setOnClickListener(this);

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
                toAct(CustomAct.class);
                break;
            case R.id.act_image:
                toAct(ImageAct.class);
                break;
            case R.id.act_login:
                toAct(LoginActivity.class);
                break;
            case R.id.act_service:
                toAct(ServiceAct.class);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(DemoConst.LogTag,"MainActivity-----onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(DemoConst.LogTag, "MainActivity-----onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(DemoConst.LogTag, "MainActivity-----onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(DemoConst.LogTag, "MainActivity-----onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(DemoConst.LogTag, "MainActivity-----onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(DemoConst.LogTag, "MainActivity-----onDestroy");
    }
}
