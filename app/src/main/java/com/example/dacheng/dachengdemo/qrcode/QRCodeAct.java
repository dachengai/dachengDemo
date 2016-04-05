package com.example.dacheng.dachengdemo.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dacheng.dachengdemo.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.CaptureActivity;


public class QRCodeAct extends CaptureActivity {

    ImageButton tara;
    Button mGenerate;
    Button mScan;
    TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_qrcode);

        tara = (ImageButton) findViewById(R.id.tarabutton);
        mScan = (Button) findViewById(R.id.scanning);
        mGenerate = (Button) findViewById(R.id.generate);
        mScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(QRCodeAct.this);
                integrator.setCaptureActivity(QRCodeScanAct.class);
                integrator.setOrientationLocked(false);
                integrator.initiateScan();
            }
        });
        mGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = QRCodeUtils.createQRCodeWithLogo("hello world", 500,
                        BitmapFactory.decodeResource(getResources(), R.mipmap.share_xd_icon));
                tara.setImageBitmap(bitmap);
            }
        });
        mContent = (TextView) findViewById(R.id.content);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            String contents = result.getContents();
            if (contents != null) {
                mContent.setText(contents);
                Toast.makeText(QRCodeAct.this,contents, Toast.LENGTH_SHORT).show();
            } else {
                mContent.setText("");
                Toast.makeText(QRCodeAct.this,"failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
