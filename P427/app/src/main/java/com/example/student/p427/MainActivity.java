package com.example.student.p427;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        TextView textView;
        WebView webView;
        Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        webView=findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new JS(),"js"); //웹뷰(HTML)에 자바스크립트 인터페이스 객체지정
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        handler=new Handler();
    }
    public void clickBt(View v){
        webView.loadUrl("http://70.12.114.135/ad/sample.html");
    }
    public void clickBt2(View v){
        handler.post(new Runnable() {
            @Override
            public void run() { //쓰레드쓰는이유:지금 이미지가 작아서 상관은없지만 나중에 큰파일을 작업시 쓰레드를 쓰는게 좋다
                webView.loadUrl("javascript:changeImg()");

            }
        });
    }
    final class JS{ //HTML에서 클릭하면 얘가 실행됨
        JS(){}
        @android.webkit.JavascriptInterface //저쪽에서 호출했을때 안드로이
        public void clickJS(String i){
            textView.setText(i);
            Log.d("[JS]","Event Process..."+i); //logcat에 찍어라

        }
    }
}
