package com.example.dacheng.dachengdemo.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dacheng.dachengdemo.R;

/**
 * Created by dacheng on 16/4/7.
 */
public class ServiceAct extends Activity implements View.OnClickListener{
    private EditText etInput;
    private TextView tvShow;

    MyService.Binder binder = null;
    MyConnection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_service);

        etInput = (EditText) findViewById(R.id.etInput);
        tvShow = (TextView) findViewById(R.id.tvShow);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnBindService).setOnClickListener(this);
        findViewById(R.id.btnSyncData).setOnClickListener(this);

        con =  new MyConnection();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.setClass(ServiceAct.this, MyService.class);
        switch (v.getId()) {
            case R.id.btnStartService: {
                // 为服务传递数据
                i.putExtra("input", etInput.getText().toString());
                startService(i);
                break;
            }
            case R.id.btnStopService: {
                stopService(i);
                break;
            }
            case R.id.btnBindService: {
                bindService(i,con , BIND_AUTO_CREATE);
                break;
            }
            case R.id.btnUnBindService: {
                unbindService(con);
                break;
            }
            case R.id.btnSyncData: {
                if (binder != null) {
                    binder.setShow(etInput.getText().toString());
                }
                break;
            }
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvShow.setText(msg.getData().getString("show"));
        }
    };

    public class MyConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyService.Binder) service;
            binder.getService().setCallBack(new MyService.CallBack() {
                @Override
                public void onShowChanged(String show) {
                    Message message = new Message();
                    Bundle b = new Bundle();
                    b.putString("show", show);
                    message.setData(b);
                    handler.sendMessage(message);
                }
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }


}
