package com.example.student.workshop;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService3 extends Service {
    public MyService3() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        final Intent sintent = new Intent(getApplicationContext(), MainActivity.class);
        sintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        sintent.putExtra("from",3);
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 10; i++){

                    sintent.putExtra("cnt",i);
                    startActivity(sintent);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(run).start();


        return super.onStartCommand(intent, flags, startId);
    }
}
