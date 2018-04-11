package com.example.student.p260;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView textview3;
    int num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textview3 =findViewById(R.id.textView3);
        Intent intent=getIntent();
        num2 = intent.getIntExtra("num2",0);
        textview3.setText(num2+"");
        clickBt2();
    }
    public void clickBt2(){
        int result=num2*2000;
        Intent intent =new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent);
        finish();

    }
}
