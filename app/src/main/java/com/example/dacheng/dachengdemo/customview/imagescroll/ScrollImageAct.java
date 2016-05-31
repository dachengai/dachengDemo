package com.example.dacheng.dachengdemo.customview.imagescroll;

import android.app.Activity;
import android.os.Bundle;

import com.example.dacheng.dachengdemo.R;


/**
 * Created by dacheng on 15/12/16.
 */
public class ScrollImageAct extends Activity {
    private ScrollImageView extendsViewGroup;
    private ScrollImageView extendsGroupViewAct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_scrollimageview);
        extendsGroupViewAct2 = (ScrollImageView) findViewById(R.id.extendsgroupview2);
    }
}
