package com.example.urvish.demo.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.urvish.demo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Open_image_on_webviewclick extends AppCompatActivity {

    WebView webView;
    ImageView selected_image;
    boolean open = false;
    RelativeLayout test_rel;

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        selected_image = findViewById(R.id.selected_image);
        test_rel = findViewById(R.id.test_rel);
        webView = findViewById(R.id.webview);

        selected_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test_rel.setVisibility(View.GONE);
                open = false;
            }
        });

        String data = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<body style=\"width:100%; padding:0; margin:0; overflow-y:auto; overflow-x:hidden; height:100%; background:#f8fbff; color:#244b82\">\n" +
                "<style type=\"text/css\">\n" +
                "img{ max-width:100%;}b,strong{ font-weight:bold;font-size:20px;}p{ font-size:18px; margin-top:0; padding-top:0}\n" +
                "</style>\n" +
                "<p><b>A)&nbsp;&nbsp;Read&nbsp;&nbsp;the&nbsp; text&nbsp;in your Practice&nbsp;Book and complete the gaps using the&nbsp;words in the box.</b>\n" +
                "<p><b>B)&nbsp;&nbsp;Now&nbsp; listen&nbsp;and check your answers.</b></p>\n" +
                "<p><img src=\"http://ec2-52-15-233-207.us-east-2.compute.amazonaws.com/storage/taskimage/15420336830.png\"><br>\n" +
                "</p>\n" +
                "</body>\n" +
                "</html>\n";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(data, "text/html", "UTF-8");

        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!open) {
                    WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                    String extra = hitTestResult.getExtra();
                    Integer type = hitTestResult.getType();

                    if (type == WebView.HitTestResult.IMAGE_TYPE) {
                        if (extra != null) {
                            if (URLUtil.isValidUrl(extra)) {
                                open = true;
                                test_rel.setVisibility(View.VISIBLE);
                                Picasso.get().load(extra).into(selected_image);
                            }
                        }
                    }
                }
                return false;
            }
        });
    }
}
