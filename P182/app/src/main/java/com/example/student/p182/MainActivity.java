package com.example.student.p182;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tx1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1=findViewById(R.id.textView);

    }
    public void click1bt(View v){
        tx1.setText("A");

    }public void click2bt(View v){
        tx1.setText("B");

    }public void click3bt(View v){
        tx1.setText("C");

    }public void click4bt(View v){
        tx1.setText("D");

    }public void click5bt(View v){
        tx1.setText("E");

    }public void click6bt(View v){
        tx1.setText("F");

    }

}
