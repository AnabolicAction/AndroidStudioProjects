package com.example.student.p425;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
        WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView =findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); //기본적으로 설정되어져있는 엔진을 이용하겠다!
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //해줘야 밑에 Url이 실행되고 동작된다
    }
    public void clickBt(View v){
        if(v.getId()==R.id.button){
            webView.loadUrl("http://m.naver.com");
        }else if(v.getId()==R.id.button2){
            webView.loadUrl("http://www.nate.com");
        }
    }
}
