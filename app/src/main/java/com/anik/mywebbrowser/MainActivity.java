package com.anik.mywebbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etxtURL;
    Button btnGo,btnFB,btnGoogle,btnOfflinePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtURL=findViewById(R.id.etxt_url);
        btnGo=findViewById(R.id.btn_go);
        btnFB=findViewById(R.id.btn_fb);
        btnGoogle=findViewById(R.id.btn_google);
        btnOfflinePage=findViewById(R.id.btn_offline_page);

        btnOfflinePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","offline");
                startActivity(intent);
            }

        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=etxtURL.getText().toString();

                if (url.isEmpty())
                {
                    etxtURL.setError("Please enter url!");
                    etxtURL.requestFocus();
                }

                else
                {
                    Intent intent=new Intent(MainActivity.this,WebActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            }
        });



        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","www.google.com");
                startActivity(intent);
            }
        });



        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","www.facebook.com");
                startActivity(intent);
            }
        });
    }
}
