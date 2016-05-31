package com.example.dacheng.dachengdemo.customview.imagecoverflow;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dacheng.dachengdemo.R;

/**
 * Created by dacheng on 16/5/31.
 */
public class CoverFlowViewAct extends Activity {
    protected static final String VIEW_LOG_TAG = "CoverFlowDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = LayoutInflater.from(this).inflate(R.layout.act_iamgecoverflow,
                null, false);
        setContentView(v);

        final CoverFlowView<MyCoverFlowAdapter> mCoverFlowView = (CoverFlowView<MyCoverFlowAdapter>) findViewById(R.id.coverflow);

        final MyCoverFlowAdapter adapter = new MyCoverFlowAdapter(this);
        mCoverFlowView.setAdapter(adapter);
        mCoverFlowView
                .setCoverFlowListener(new CoverFlowView.CoverFlowListener<MyCoverFlowAdapter>() {

                    @Override
                    public void imageOnTop(
                            CoverFlowView<MyCoverFlowAdapter> view,
                            int position, float left, float top, float right,
                            float bottom) {
                        Log.e(VIEW_LOG_TAG, position + " on top!");
                    }

                    @Override
                    public void topImageClicked(
                            CoverFlowView<MyCoverFlowAdapter> view, int position) {
                        Log.e(VIEW_LOG_TAG, position + " clicked!");
                    }

                    @Override
                    public void invalidationCompleted() {

                    }
                });

        mCoverFlowView
                .setTopImageLongClickListener(new CoverFlowView.TopImageLongClickListener() {

                    @Override
                    public void onLongClick(int position) {
                        Log.e(VIEW_LOG_TAG, "top image long clicked == >"
                                + position);
                    }
                });

        findViewById(R.id.change_bitmap_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeBitmap();
            }
        });
    }
}
