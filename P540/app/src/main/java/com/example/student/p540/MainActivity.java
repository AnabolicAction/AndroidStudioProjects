package com.example.student.p540;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
MyHandler myHandler;
//MyHandler2 myHandler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);
        myHandler=new MyHandler();
        //myHandler2=new MyHandler2();
    }
    public void clickBt(View v){
        t.start();
    }
    Thread t =new Thread(new Runnable() {
        int i=0;
        @Override
        public void run() {
            while (i<=10) {
                i++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                Bundle bundle = msg.getData();
                bundle.putInt("data", i); //주기적으로 보내준다 그거를 MyHandler가 받는다
                myHandler.sendMessage(msg); //변경된사항을 핸들러에게 알려주겠다
            }
        }
    });


/*    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Message msg2 =new Message();
            Bundle bundle=msg2.getData();
            bundle.putInt("data2",11);
            myHandler2.sendMessage(msg2);
            }
        }*/
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle= msg.getData();
            int result=bundle.getInt("data");
            if (result==11){
                textView.setText("Finish");
            }else{
                textView.setText(bundle.getInt("data")+"");
            }
        }
    }
    }






