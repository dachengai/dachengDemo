package com.example.dacheng.dachengdemo.customview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.customview.autoscrolltitle.ScrollTitleAct;
import com.example.dacheng.dachengdemo.customview.progress.ProgressAct;

/**
 * Created by dacheng on 16/4/20.
 */
public class CustomAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_custom);
        findViewById(R.id.custom_progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAct(ProgressAct.class);
            }
        });
        findViewById(R.id.custom_scrolltitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAct(ScrollTitleAct.class);
            }
        });
    }

    private void toAct(Class cls){
        Intent intent = new Intent(this,cls);
        this.startActivity(intent);
    }
}
