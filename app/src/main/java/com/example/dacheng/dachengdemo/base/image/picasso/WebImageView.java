package com.example.dacheng.dachengdemo.base.image.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.dacheng.dachengdemo.base.image.picasso.transformation.CircleTransformation;
import com.example.dacheng.dachengdemo.base.image.picasso.transformation.RoundTransformation;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;

import java.io.File;

/**
 * Created by dacheng on 16/4/6.
 */
public class WebImageView extends ImageView {
    private boolean mIsAttachedToWindow;
    private Uri mUri;
    private Drawable mDefaultDrawable;
    private Transformation mTransformation;
    boolean mNeedResize;
    private int mWidth;
    private int mHeight;
    private boolean isWidthFixMode;
    Callback mCallback;
    private int mRes;
    static WebImageView.OnLoadFromListener mLoadFromListener;

    public static void setLoadFromListener(WebImageView.OnLoadFromListener listener) {
        mLoadFromListener = listener;
    }

    public WebImageView(Context context) {
        this(context, (AttributeSet)null);
    }

    public WebImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mWidth = 0;
        this.mHeight = 0;
        this.isWidthFixMode = false;
    }

    public void setDefaultDrawable(Drawable drawable) {
        this.mDefaultDrawable = drawable;
    }

    public void setDefaultResId(int id) {
        this.mDefaultDrawable = this.getResources().getDrawable(id);
    }

    public void setImageUrl(String url) {
        this.setImageUrl(url, (Transformation)null);
    }

    public void setImageUrl(String url, Transformation transformation) {
        try {
            this.setImageUri(Uri.parse(url), transformation, (Callback)null, false, 0, 0);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void setImageUrl(String url, Transformation transformation, Callback callback) {
        try {
            this.setImageUri(Uri.parse(url), transformation, callback, false, 0, 0);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void setResizeImageUrl(String url, int w, int h) {
        try {
            this.setImageUri(Uri.parse(url), (Transformation)null, (Callback)null, true, w, h);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void setCircleImageUrl(String url, Callback callback) {
        CircleTransformation transformation = new CircleTransformation();
        this.setImageUrl(url, transformation, callback);
    }

    public void setCircleImageUrl(String url) {
        this.setCircleImageUrl(url, (Callback) null);
    }

    public void setALLCornerImageUrl(String url, final int corner,final int margin) {
        this.setRoundCornerImageUrl(url, corner, margin, RoundTransformation.CornerType.ALL);
    }

    public void setRoundCornerImageUrl(String url, final int corner,final int margin,RoundTransformation.CornerType type) {
        RoundTransformation transformation = new RoundTransformation(corner,margin,type);
        setImageUrl(url, transformation);
    }

    private void setImageUri(Uri uri, Transformation transformation, Callback callback, boolean needResize, int width, int height) {
        this.mRes = -1;
        this.mTransformation = transformation;
        this.mNeedResize = needResize;
        this.mWidth = width;
        this.mHeight = height;
        this.mCallback = callback;
        if(null != uri) {
           // WebImageView.PictUrlHandler handler = new WebImageView.PictUrlHandler(this.getContext());
          //  uri = handler.getCompUrl(uri);
            this.mUri = uri;
            if(this.mIsAttachedToWindow) {
                RequestCreator requestCreator = Picasso.with(this.getContext()).load(this.mUri);
                if(null != this.mDefaultDrawable) {
                    requestCreator = requestCreator.placeholder(this.mDefaultDrawable);
                }

                if(null != transformation) {
                    requestCreator = requestCreator.transform(transformation);
                }

                if(needResize && width != 0 && height != 0) {
                    requestCreator.resize(width, height).centerCrop();
                }

                requestCreator.into(this, callback);
            }

        }
    }

    public void setImagePath(String path) {
        this.setImagePath(path, (Transformation)null, false, 0, 0);
    }

    public void setImagePath(String path, int width, int height) {
        this.setImagePath(path, (Transformation)null, true, width, height);
    }

    public void setImagePath(String path, Transformation transformation, boolean needResize, int width, int height) {
        this.mTransformation = transformation;
        Uri uri = Uri.fromFile(new File(path));
        if(null != uri) {
            this.setImageUri(uri, transformation, (Callback)null, needResize, width, height);
        }
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.mRes = resId;
        this.mUri = null;
    }
    @Override
    public void onAttachedToWindow() {
        this.mIsAttachedToWindow = true;
        if(null != this.mUri) {
            this.setImageUri(this.mUri, this.mTransformation, this.mCallback, this.mNeedResize, this.mWidth, this.mHeight);
        }

        if(this.mRes != -1) {
            this.setImageResource(this.mRes);
        }

        super.onAttachedToWindow();
    }
    @Override
    public void onDetachedFromWindow() {
        Picasso.with(this.getContext()).cancelRequest(this);
        this.mIsAttachedToWindow = false;
        this.setImageBitmap((Bitmap)null);
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(this.isWidthFixMode) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = 0;
            if(this.mWidth > 0) {
                height = width * this.mHeight / this.mWidth;
            }

            this.setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }



    public void setAspectRatio(int width, int height) {
        if(width > 0 && height > 0) {
            this.isWidthFixMode = true;
            this.mWidth = width;
            this.mHeight = height;
        }

    }

   /* public WebImageView.PictUrlHandler getPictUrlHandler() {
        return new WebImageView.PictUrlHandler(this.getContext());
    }
*/
    /*public class PictUrlHandler {
        static final int DefaultDpi = 320;
        Context mContext;

        public PictUrlHandler(Context context) {
            this.mContext = context;
        }

        private NetworkType getCurrentNetType() {
            ConnectivityManager connManager = (ConnectivityManager)this.mContext.getSystemService("connectivity");
            NetworkInfo wifi = connManager.getNetworkInfo(1);
            NetworkInfo gprs = connManager.getNetworkInfo(0);
            return wifi != null && wifi.getState() == NetworkInfo.State.CONNECTED?NetworkType.wifi:(gprs != null && gprs.getState() == NetworkInfo.State.CONNECTED?NetworkType.mobile:NetworkType.NONE);
        }

        public Uri getCompUrl(Uri oriUri) {
            try {
                if(PictStrategy.instance().getPreConfig() == null) {
                    return oriUri;
                } else {
                    String e = oriUri.toString();
                    PictUrlParse urlParse = new PictUrlParse(e);
                    if(urlParse.ifOnlyOriPath) {
                        return oriUri;
                    } else {
                        String oriPath = urlParse.oriPath;
                        if(!urlParse.isValid()) {
                            return oriUri;
                        } else {
                            PictUrlPost targetPost = urlParse.pictUrlPost.clone();
                            if(!targetPost.isPostValid()) {
                                return oriUri;
                            } else {
                                if(targetPost.getPictUrlPostKey().getCompHeight() != 999 && targetPost.getPictUrlPostKey().getCompHeight() != 9999) {
                                    this.changePost(targetPost);
                                }

                                PictStrategy.instance().setNetworkType(this.getCurrentNetType());
                                MatchPictResult result = PictStrategy.instance().getMatchPict(targetPost.getPictUrlPostKey());
                                if(!result.isValid()) {
                                    return oriUri;
                                } else {
                                    Iterator item = result.pictConfigItems.iterator();

                                    String tmpUrl;
                                    do {
                                        if(!item.hasNext()) {
                                            PictConfigItem item2 = (PictConfigItem)result.pictConfigItems.get(result.resultIndex);
                                            return Uri.parse(oriPath + "_" + item2.pictUrlPost.OriPostString);
                                        }

                                        PictConfigItem item1 = (PictConfigItem)item.next();
                                        tmpUrl = oriPath + "_" + item1.pictUrlPost.OriPostString;
                                    } while(!this.ifBitmapCached(tmpUrl));

                                    return Uri.parse(tmpUrl);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable var10) {
                return oriUri;
            }
        }

        void changePost(PictUrlPost post) {
            if(WebImageView.this.getHeight() >= 0 && WebImageView.this.getWidth() >= 0) {
                post.getPictUrlPostKey().setWidthAndHeight(WebImageView.this.getWidth(), WebImageView.this.getHeight());
            } else {
                DisplayMetrics dm = WebImageView.this.getResources().getDisplayMetrics();
                int tmpH = post.getPictUrlPostKey().getCompHeight();
                int tmpW = post.getPictUrlPostKey().getCompWidth();
                double rate = (double)dm.densityDpi / 320.0D;
                tmpH = (int)((double)tmpH * rate);
                tmpW = (int)((double)tmpW * rate);
                post.getPictUrlPostKey().setWidthAndHeight(tmpW, tmpH);
            }
        }

        boolean ifBitmapCached(String url) {
            Uri uri = Uri.parse(url);
            long start = System.currentTimeMillis();
            RequestCreator requestCreator = Picasso.with(WebImageView.this.getContext()).load(uri);
            if(null != WebImageView.this.mDefaultDrawable) {
                requestCreator = requestCreator.placeholder(WebImageView.this.mDefaultDrawable);
            }

            if(null != WebImageView.this.mTransformation) {
                requestCreator = requestCreator.transform(WebImageView.this.mTransformation);
            }

            if(WebImageView.this.mNeedResize && WebImageView.this.mWidth != 0 && WebImageView.this.mHeight != 0) {
                requestCreator.resize(WebImageView.this.mWidth, WebImageView.this.mHeight).centerCrop();
            }

            boolean result = requestCreator.ifCached();
            Log.d("test", "time resue is :" + (System.currentTimeMillis() - start));
            return result;
        }
    }*/

    public interface OnLoadFromListener {
        void loadFrom(String var1, long var2);
    }
}
