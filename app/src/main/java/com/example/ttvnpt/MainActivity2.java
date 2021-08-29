package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wv=findViewById(R.id.wv);
        Intent intent=getIntent();
        String link=intent.getStringExtra("link");
        wv.loadUrl(link);
        wv.setWebViewClient(new WebViewClient());
    }
}