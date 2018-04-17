package com.example.student.p553;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView,imageView2,imageView3;
    MyHandler myHandler;
    Intent intent;

    int imgs[]={
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =findViewById(R.id.imageView);
        imageView2 =findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        myHandler=new MyHandler();

        intent = new Intent(getApplicationContext(),MyService.class);
    }


    Runnable r1=new Runnable() {
        @Override
        public void run() {  //상단의 이미지 변경
            for(int i=1;i<=7;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Image 변경


                final int finalI = i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(imgs[finalI -1]);


                    }
                });

            }
        }
    };

    Runnable r2=new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<=7;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Image 변경
                Message msg = new Message();
                Bundle bundle = msg.getData();
                bundle.putInt("data", i); //주기적으로 보내준다 그거를 MyHandler가 받는다
                myHandler.sendMessage(msg); //변경된사항을 핸들러에게 알려주겠다

            }
        }
    };

/*    Thread t1 =new Thread(new Runnable() {


    });

    Thread t2 =new Thread(new Runnable() { //하단의 이미지 변경

    });*/

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle= msg.getData();
            int result=bundle.getInt("data");

            switch (result){

                case 1:
                    imageView2.setImageResource(R.drawable.image1);
                    break;
                case 2:
                    imageView2.setImageResource(R.drawable.image2);
                    break;
                case 3:
                    imageView2.setImageResource(R.drawable.image3);
                    break;
                case 4:
                    imageView2.setImageResource(R.drawable.image4);
                    break;
                case 5:
                    imageView2.setImageResource(R.drawable.image5);
                    break;
                case 6:
                    imageView2.setImageResource(R.drawable.image6);
                    break;
                case 7:
                    imageView2.setImageResource(R.drawable.image7);
                    break;


            }

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        int num= intent.getIntExtra("data",0);
        imageView3.setImageResource(imgs[num-1]);
        super.onNewIntent(intent);
    }
    Thread t1=new Thread(r1);
    Thread t2=new Thread(r2);
    public void clickBt(View v){

        t1.start(); //상단이미지동작
        t2.start();//하단이미지동작

        startService(intent);
    }
    public void clickBy2(View v){


    }

}
