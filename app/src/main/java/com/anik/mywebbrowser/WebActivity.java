package com.anik.mywebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web=findViewById(R.id.web);

        String getUrl=getIntent().getExtras().getString("url");

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);


        Toast.makeText(this, "Simple Tost", Toast.LENGTH_SHORT).show();

       if (getUrl.equals("offline"))
       {
           web.loadUrl("file:///android_asset/hello.html");

       }
       else {
           web.loadUrl("http://" + getUrl);
       }



    }


    //for backpress in webview


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        } else {
            finish();
        }

        return super.onKeyDown(keyCode,event);
    }
}
