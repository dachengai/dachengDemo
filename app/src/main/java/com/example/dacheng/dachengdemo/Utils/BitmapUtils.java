package com.example.dacheng.dachengdemo.Utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by dacheng on 16/3/10.
 * bitmap 相关工具类
 */
public class BitmapUtils {
    /**
     * centerCrop 方式剪裁图片  (可以参考android ImageView 源码实现方式)
     * @param
     * @param vwidth
     * @param vheight
     * @return
     */
    public static Bitmap centerCrop(Bitmap src ,int vwidth ,int vheight){

        if (src == null || vwidth == 0 || vheight == 0) {
            return null;
        }
        Matrix mMatrix = new Matrix();
        float scale;
        float dx = 0, dy = 0;
        int dwidth = src.getWidth();
        int dheight = src.getHeight();
        if (dwidth * vheight > vwidth * dheight) {
            scale = (float) vheight / (float) dheight;
            dx = (vwidth - dwidth * scale) * 0.5f;
        } else {
            scale = (float) vwidth / (float) dwidth;
            dy = (vheight - dheight * scale) * 0.5f;
        }
        mMatrix.setScale(scale, scale);
        mMatrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
        Bitmap tempBitmap = Bitmap.createBitmap(vwidth,vheight,src.getConfig());
        Canvas canvas = new Canvas(tempBitmap);
        canvas.drawBitmap(src,mMatrix,new Paint(Paint.ANTI_ALIAS_FLAG));
        canvas.setBitmap(null);

        return tempBitmap;

    }
}
