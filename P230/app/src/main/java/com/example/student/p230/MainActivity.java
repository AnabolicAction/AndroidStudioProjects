package com.example.student.p230;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    WebView web;
    EditText tx_id,tx_pwd,tx_id2,tx_pwd2;
    RelativeLayout loginlay,createlay;
    LinearLayout take;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();
    }
    public void makeui(){
        take=findViewById(R.id.take);
        loginlay=findViewById(R.id.loginlay);
        createlay=findViewById(R.id.createlay);
        web=findViewById(R.id.naver1);

       web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        createlay.setVisibility(View.INVISIBLE);
        loginlay.setVisibility(View.INVISIBLE);
        web.setVisibility(View.INVISIBLE);
    }


    public void clickBt(View v){
        if(v.getId()==R.id.create){
            take.setVisibility(View.INVISIBLE);
            loginlay.setVisibility(View.INVISIBLE);
            web.setVisibility(View.INVISIBLE);
            createlay.setVisibility(View.VISIBLE);

        }else if(v.getId()==R.id.login){
            take.setVisibility(View.INVISIBLE);
            web.setVisibility(View.INVISIBLE);
            createlay.setVisibility(View.INVISIBLE);
            loginlay.setVisibility(View.VISIBLE);

        }else if(v.getId()==R.id.naver){
            take.setVisibility(View.INVISIBLE);
            createlay.setVisibility(View.INVISIBLE);
            loginlay.setVisibility(View.INVISIBLE);
            web.setVisibility(View.VISIBLE);
            web.loadUrl("http://m.naver.com");

        }else if(v.getId()==R.id.home){
            createlay.setVisibility(View.INVISIBLE);
            loginlay.setVisibility(View.INVISIBLE);
            web.setVisibility(View.INVISIBLE);
            take.setVisibility(View.VISIBLE);

        }
    }
}
