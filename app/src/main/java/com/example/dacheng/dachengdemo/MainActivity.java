package com.example.dacheng.dachengdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dacheng.dachengdemo.dialog.DialogAct;
import com.example.dacheng.dachengdemo.recyclerview.RecyclerViewAct;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mRecycler;
    private Button mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDialog = (Button) findViewById(R.id.act_dialog);
        mRecycler = (Button) findViewById(R.id.act_recyclerview);
        mDialog.setOnClickListener(this);
        mRecycler.setOnClickListener(this);
    }






    private void toAct(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
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
            default:
                break;
        }
    }
}
