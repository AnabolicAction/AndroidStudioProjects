package com.example.student.workshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Intent intent;
    TextView textView;
    ProgressBar progressBar2;
    ImageView imageView;
    FrameLayout frameLayout;

    ProgressDialog progressDialog;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.framelayout);
        progressBar2=findViewById(R.id.progressBar2);
        progressBar2.setMax(10);
        imageView=findViewById(R.id.imageView2);
    }

    @Override
    protected void onNewIntent(Intent intent) {
       int from= intent.getIntExtra("from",0);
       if (from==1){
           frameLayout.setVisibility(View.VISIBLE);
       }else if(from==2){
           progressBar2.setProgress(intent.getIntExtra("cnt",0));
       }else if(from==3){
          int cnt= intent.getIntExtra("cnt",0);
            if (cnt%2==0){
                imageView.setImageResource(R.drawable.cuttler);
            }else{
                imageView.setImageResource(R.drawable.ulli);
            }
       }
    }

    public void clickBt(View v) {
        Intent intent=new Intent(this,MyService1.class);
        startService(intent);
    }
    public void clickBt2(View v) {
        Intent intent1=new Intent(this,MyService2.class);
        Intent intent2=new Intent(this,MyService3.class);
        startService(intent1);
        startService(intent2);
    }
}
