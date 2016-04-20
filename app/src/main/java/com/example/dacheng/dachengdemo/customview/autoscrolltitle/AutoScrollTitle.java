package com.example.dacheng.dachengdemo.customview.autoscrolltitle;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.dacheng.dachengdemo.R;
import com.example.dacheng.dachengdemo.customview.autoscrolltitle.data.ScrollTitleData;

import java.util.ArrayList;

/**
 * Created by dacheng on 16/4/20.
 */
public class AutoScrollTitle extends LinearLayout{
    private Context mContext;
    private ViewFlipper viewFlipper;
    private View scrollTitleView;
    private int orientation;
    private int flipInterval = 3000;
    public AutoScrollTitle(Context context) {
        this(context,null);
    }

    public AutoScrollTitle(Context context,AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initLayout();

    }
    /*设置Title数据*/
    public <T extends ScrollTitleData> void setScrollTitle(ArrayList<T> list) {
        if(viewFlipper == null || list == null || list.size() == 0 ){ return; }
        viewFlipper.removeAllViews();
        switch (orientation) {
            case LinearLayout.HORIZONTAL:
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_title_horizontal_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_title_horizontal_out));
                break;
            case LinearLayout.VERTICAL:
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_title_vertical_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_title_vertical_out));
                break;
            default:
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_title_vertical_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_title_vertical_out));
                break;
        }
        T item = null;
        for(int i = 0 ;i < list.size(); i++){
            item = list.get(i);
            if(item != null){
                TextView textView = new TextView(mContext);
                textView.setTextSize(14);
                textView.setTextColor(Color.parseColor("#666666"));
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(item.getTitle());
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO 跳转
                    }
                });
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                viewFlipper.addView(textView, lp);
            }
        }
        viewFlipper.setFlipInterval(flipInterval);
        viewFlipper.startFlipping();
        viewFlipper.showNext();

    }

    /**
     * 初始化布局
     */
    public void initLayout() {
        scrollTitleView = LayoutInflater.from(mContext).inflate(
                R.layout.notice_layout, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        addView(scrollTitleView, layoutParams);
        viewFlipper = (ViewFlipper) scrollTitleView
                .findViewById(R.id.flipper_scrollTitle);

    }

    public void setScrollOrientation(int orientation){
        this.orientation = orientation;
    }

    public void setFlipInterval(int interval){
        flipInterval = interval;
    }

}
