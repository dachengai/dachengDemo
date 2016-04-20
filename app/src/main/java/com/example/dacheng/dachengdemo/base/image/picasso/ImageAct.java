package com.example.dacheng.dachengdemo.base.image.picasso;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.dacheng.dachengdemo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dacheng on 16/4/7.
 */
public class ImageAct extends Activity {

    private WebImageView mWebImageView;
    private SimpleDraweeView mGenericDraweeView;
    private static String url= "http://s16.mogucdn.com/p1/150918/1t83k6_ieywenrygbsgin3cgmzdambqmeyde_790x1212.jpg_220x330.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Set<RequestListener> listeners = new HashSet<>();
        listeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setRequestListeners(listeners)
                .setBitmapsConfig(Bitmap.Config.ARGB_8888)
                .build();
        Fresco.initialize(this, config);
        setContentView(R.layout.act_image);
        mWebImageView = (WebImageView) findViewById(R.id.image_picasso);
        mGenericDraweeView = (SimpleDraweeView) findViewById(R.id.image_fresco);
        mWebImageView.setImageUrl(url);
        mGenericDraweeView.setImageURI(Uri.parse(url));

    }
}
