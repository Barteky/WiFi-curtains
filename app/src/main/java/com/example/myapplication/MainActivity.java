package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String ip = "http://192.168.0.100";
    String ip1 = "192";
    String ip2 = "168";
    String ip3= "0";
    String ip4 = "100";

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webViewer);
        webView.setWebViewClient(new WebViewClient());

        final Button odslaniaj = (Button) findViewById(R.id.odslaniaj);
        final Button zaslaniaj = (Button) findViewById(R.id.zaslaniaj);

        final TextView ip_text = (TextView) findViewById(R.id.ip);
        final TextView ip2_text = (TextView) findViewById(R.id.ip2);
        final TextView ip3_text = (TextView) findViewById(R.id.ip3);
        final TextView ip4_text = (TextView) findViewById(R.id.ip4);


        final Button connect = (Button) findViewById(R.id.connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip1=ip_text.getText()+"";
                ip2=ip2_text.getText()+"";
                ip3=ip3_text.getText()+"";
                ip4=ip4_text.getText()+"";
                ip="http://" + ip4 + "." + ip3 + "." + ip2 + "." + ip1;
                webView.loadUrl(ip);
            }
        });


        final Button odslon = (Button) findViewById(R.id.odslon);
        odslon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webView.loadUrl(ip + "/ODSLON");
            }
        });

        final Button zaslon = (Button) findViewById(R.id.zaslon);
        zaslon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               webView.loadUrl(ip + "/ZASLON");
            }
        });



        View.OnTouchListener elem = new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (v.getId()) {

                    case R.id.odslaniaj:
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                           webView.loadUrl(ip + "/ODSLANIANIE");

                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            webView.loadUrl(ip +  "/stop");

                        }
                        break;

                    case R.id.zaslaniaj:
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            webView.loadUrl(ip +  "/ZASLANIANIEE");

                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            webView.loadUrl(ip +  "/stop");

                        }
                        break;
                }
                return true;
            }
        };

        odslaniaj.setOnTouchListener(elem);
        zaslaniaj.setOnTouchListener(elem);


    }
}