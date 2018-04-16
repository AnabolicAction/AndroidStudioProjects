package com.example.student.p536;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
    }
    public void clickBt(View v){ //버튼클릭시 스래드 동작
        t.start();
    }
    Thread t=new Thread(new Runnable() {
        int i=1;
        @Override
        public void run() {
            while (i <=10){
                try {
                    Thread.sleep(500); //
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(i+"");
                    }
                });
               // textView.setText(i+""); //메인스레드안에 있는 서브스레드안에서 메인스레드의 Ui를 변경할수없다 그래서 runOnUiThread이걸 만들고 넣어줘야한다
            }
        }
    });
}
