package com.ourcoaching.simplewebviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private final String Website_URL="https://www.ourcoaching.com";
    // Downloaded from https://github.com/KuKapoor02
    // Visit https://www.ourcoaching.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Website_URL);
    }
}
