package com.example.dacheng.dachengdemo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.dacheng.dachengdemo.R;

/**
 * Created by dacheng on 16/3/22.
 */
public class DialogAct extends Activity {
    private Button mShowDialogBtn;
    private Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = new Dialog(this);
        mDialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_dialog);
        View mContentView = LayoutInflater.from(this).inflate(R.layout.act_dialog_content_layout,null);
        mDialog.setContentView(mContentView);
        mDialog.setCanceledOnTouchOutside(true);
        mShowDialogBtn = (Button) findViewById(R.id.dialog_btn);
        mShowDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.show();
                setWindowsSize();
            }
        });




    }


    public void setWindowsSize() {
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            lp.type = WindowManager.LayoutParams.TYPE_TOAST;
        } else {
            lp.type = WindowManager.LayoutParams.TYPE_PHONE;
        }*/
        lp.width = (int) (screenWidth * 0.80);
        lp.height = (int) (screenHeight * 0.60);
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }
}
