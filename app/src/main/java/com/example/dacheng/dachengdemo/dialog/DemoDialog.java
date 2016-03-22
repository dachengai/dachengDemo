package com.example.dacheng.dachengdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dacheng.dachengdemo.R;

/**
 * Created by dacheng on 16/3/22.
 */
public class DemoDialog extends Dialog {
    public DemoDialog(Context context) {
        super(context);

    }

    public DemoDialog(Context context, int theme) {
        super(context, theme);
    }


    private static  class Builder{
        private Context context;

        public Builder(Context context){
            this.context = context;
        }

        public DemoDialog create(){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.act_dialog_content_layout, null);
            final DemoDialog dialog = new DemoDialog(context);
            dialog.setContentView(view);

            return dialog;
        }
    }
}
