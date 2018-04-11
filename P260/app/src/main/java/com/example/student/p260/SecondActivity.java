package com.example.student.p260;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textview2;
    int num1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textview2 =findViewById(R.id.textView2);
        Intent intent=getIntent();
        int num1 = intent.getIntExtra("num1",0);
        textview2.setText(num1+"");
    }
    public void clickBt2(View v){
        int result=num1*3000;
        Intent intent =new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent);
        finish();

    }
}
