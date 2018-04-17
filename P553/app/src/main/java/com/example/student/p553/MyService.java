package com.example.student.p553;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;

public class MyService extends Service {
    public MyService() {
    }
    Thread t1;
    Intent intent;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent ==null) {
            return Service.START_STICKY;

        }else{

            t1=new Thread(r1);
            t1.start(); //상단이미지동작

        }
        private void processCommand(Intent intent){

        }



        return super.onStartCommand(intent, flags, startId);
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

                intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra("data",i);
                startActivity(intent);



            }
        }
    };



}
