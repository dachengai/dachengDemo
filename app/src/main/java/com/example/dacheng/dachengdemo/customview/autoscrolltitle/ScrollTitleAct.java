package com.example.dacheng.dachengdemo.customview.autoscrolltitle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.customview.autoscrolltitle.data.ScrollTitleData;
import com.example.dacheng.dachengdemo.customview.progress.ProgressAct;

import java.util.ArrayList;

/**
 * Created by dacheng on 16/4/20.
 */
public class ScrollTitleAct extends Activity {
    AutoScrollTitle mAutoScrollTitle;
    private ArrayList<ScrollTitleData> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_scrolltitle);
         mAutoScrollTitle = (AutoScrollTitle) findViewById(R.id.announce_txt);

         mAutoScrollTitle.setScrollOrientation(LinearLayout.HORIZONTAL);
         mAutoScrollTitle.setFlipInterval(10000);

        for(int i = 0; i < 5;i++){
            ScrollTitleData data = new ScrollTitleData();
            data.setTitle("测试测试"+i);
            datas.add(data);
        }
        mAutoScrollTitle.setScrollTitle(datas);

    }

}
