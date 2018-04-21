package com.raspi.pisecurity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

public class camView extends AppCompatActivity {

    private WebView webView;

    Activity activity;
    @Override



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_view);

        WebView engine = (WebView) findViewById(R.id.webView);
        engine.setInitialScale(1);
        engine.getSettings().setLoadWithOverviewMode(true);
        engine.getSettings().setUseWideViewPort(true);
        engine.getSettings().setJavaScriptEnabled(true);
        engine.loadUrl("http://92.13.238.188:8081");


    }
}