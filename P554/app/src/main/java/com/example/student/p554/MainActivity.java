package com.example.student.p554;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    MyTask myTask;
    Button button;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);
        progressBar=findViewById(R.id.progressBar);
        progressDialog= new ProgressDialog(MainActivity.this);
        button=findViewById(R.id.button);

    }

    public void clickBt(View v){
        myTask=new MyTask("192.168.111.100");
            myTask.execute(); //스레드 수행
            Log.d("click.....","@@@@@@@@@@@@@@@");
            //int result =myTask.execute().get();
            //get을 안썻을때 익스큐트안되고 쓰레드가 독립적으로 흘러내림(기다려주지않음),get을쓰면 상태에따라 차래대로 진행된다

      /*  myTask.execute();
        Log.d("click.....","@@@@@@@@@@@@@@@");*/

    }

    class MyTask extends AsyncTask<String,Integer,Integer>{

        String msg;
        public MyTask(String msg){
            this.msg =msg;
        }

        public MyTask(){

        }

        @Override
        protected void onPreExecute() {  //스레드시작전 , 메인스레드 유아이변경가능,원래는 불가능,값을 입력부분
            progressBar.setMax(55);
            textView.setText("Start Thread...");
            button.setEnabled(false);
            progressDialog.setTitle("Progress");
            progressDialog.setMessage("Ing....");
            progressDialog.show();
        }

        @Override
        protected Integer doInBackground(String... Strings) { //run 부분이다. 메인스레드,실제 스래드가 수행되는부분
            int result=0;
            Log.d("doInBackground.....",msg+"start..@@@@@@@@@@@@@@@");
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result +=1;
                publishProgress(result); //자동적으로 onProgressUpdate 이따다가 여준다.
            }
            Log.d("doInBackground.....","end..@@@@@@@@@@@@@@@");

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) { //
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer result) {  //스레드끝, 메인스레드 유아이변경가능,원래는 불가능
            textView.setText("End Thread"+result);
            button.setEnabled(true);
            progressDialog.dismiss();
        }
    }
}
