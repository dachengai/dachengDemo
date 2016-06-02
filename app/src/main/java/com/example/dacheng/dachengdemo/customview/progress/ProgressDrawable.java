package com.example.dacheng.dachengdemo.customview.progress;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by dacheng on 16/6/1.
 */
public class ProgressDrawable extends Drawable{
    public static final String TAG = "ProgressDrawble";



    private Shape shape = Shape.CIRCLE;

    private final Paint paint;
    private float progress;
    private int lineColor;//线条颜色（）
    private float circleScale;
    private final RectF arcElements;
    private int lineWidth;


    ProgressDrawable(int lineWidth, int lineColor,float circleScale,Shape shape) {
        this.progress = 0;
        this.lineColor = lineColor;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.lineWidth = lineWidth;
        this.arcElements = new RectF();
        this.shape = shape;
        this.circleScale = circleScale;
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect bounds = getBounds();

        int size = Math.min(bounds.height(), bounds.width());
        float outerRadius = (size / 2) - (lineWidth / 2);
        float innerRadius = outerRadius * circleScale;
        float offsetX = (bounds.width() - outerRadius * 2) / 2;
        float offsetY = (bounds.height() - outerRadius * 2) / 2;

        int halfRingWidth = lineWidth / 2;
        float arcX0 = offsetX + halfRingWidth;
        float arcY0 = offsetY + halfRingWidth;
        float arcX = offsetX + outerRadius * 2 - halfRingWidth;
        float arcY = offsetY + outerRadius * 2 - halfRingWidth;

        paint.setColor(lineColor);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(lineWidth);
        switch (shape){
            case LINE :
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.parseColor("#cccccc"));
                canvas.drawLine(bounds.left,bounds.centerY(),bounds.left+bounds.width(),bounds.centerY(),paint);
                paint.setColor(lineColor);
                canvas.drawLine(bounds.left,bounds.centerY(),bounds.left+bounds.width()*progress,bounds.centerY(),paint);

                break;
            case CIRCLE:
                paint.setStyle(Paint.Style.FILL);
                arcElements.set(arcX0, arcY0, arcX, arcY);
                canvas.drawArc(arcElements, 90, -360*progress, true, paint);
                break;
            case RING:
                paint.setStyle(Paint.Style.STROKE);
                arcElements.set(arcX0, arcY0, arcX, arcY);
                canvas.drawArc(arcElements, 90, -360*progress, false, paint);
                break;
            default:
                break;
        }

    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return 1 - paint.getAlpha();
    }



    public float getProgress() {
        return progress;
    }

    /**
     * 设置进度
     * @param progress
     */
    public void setProgress(float progress) {
        if( progress <= 1 && progress >= 0){
            this.progress = progress;
        }
        invalidateSelf();
    }


    public float getCircleScale() {
        return circleScale;
    }


    public void setCircleScale(float circleScale) {
        this.circleScale = circleScale;
        invalidateSelf();
    }

    public int getLineColor() {
        return lineColor;
    }



    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        invalidateSelf();
    }



    public static class Builder {
        int lineWidth;

        int lineColor;

        float circleScale = 0.75f;

        Shape shape = Shape.CIRCLE;

        public Builder setLineWidth(int ringWidth) {
            this.lineWidth = ringWidth;
            return this;
        }

        public Builder setLineColor(int lineColor) {
            this.lineColor = lineColor;
            return this;
        }

        public Builder setInnerCircleScale(float circleScale) {
            this.circleScale = circleScale;
            return this;
        }

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }


        public ProgressDrawable create() {
            return new ProgressDrawable(lineWidth,lineColor,circleScale, shape);
        }

    }

    public enum Shape{
        LINE,//线
        CIRCLE,//圆形
        RING,//圆环
    }
}
