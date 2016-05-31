package com.example.dacheng.dachengdemo.customview.imagecoverflow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.dacheng.dachengdemo.R;


/**
 * Created by dacheng on 16/5/31.
 */
public class MyCoverFlowAdapter extends CoverFlowAdapter  {
    private boolean dataChanged;

    public MyCoverFlowAdapter(Context context) {

        image1 = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.test);

        image2 = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_launcher);
    }

    public void changeBitmap() {
        dataChanged = true;

        notifyDataSetChanged();
    }

    private Bitmap image1 = null;

    private Bitmap image2 = null;

    @Override
    public int getCount() {
        return dataChanged ? 3 : 8;
    }

    @Override
    public Bitmap getImage(final int position) {
        return (dataChanged && position == 0) ? image2 : image1;
    }
}
