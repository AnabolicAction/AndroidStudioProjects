package com.example.student.p593;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    LocationTask locationTask;
    ProgressDialog  progressDialog;
    boolean flag = true;
    AlertDialog.Builder alBuilder;
    AlertDialog dialog;
    LoginTask loginTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        progressDialog = new ProgressDialog(MainActivity.this);
        alBuilder = new AlertDialog.Builder(MainActivity.this);
        //new Thread(r).start();

    }



    //3초마다 한번씩 경도와 위도를 가져와서 LocationTask 로 보낸다
    Runnable r = new Runnable() {
        @Override
        public void run() {
            while(flag){
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //좌표를 가져와서 LocationTask로 봰다
                locationTask = new LocationTask("http://70.12.114.135/android/location.jsp");
                locationTask.execute(37.12,127.123);

            }
        }  //run

    };



    public void clickBt(View v){

        String id = editText1.getText().toString();
        String pwd = editText2.getText().toString();
        if (id == null || pwd == null || id.equals("") || pwd.equals("")) {
            return;
        }
        loginTask = new LoginTask("http://70.12.114.135/android/login.jsp");
        loginTask.execute(id.trim(), pwd.trim());


    }


    class LocationTask extends AsyncTask<Double,Void,String> {

        String url;

        LocationTask() {
        }

        LocationTask(String url) {
            this.url = url;
        }

        @Override
        protected String doInBackground(Double... doubles) {
            double lat = doubles[0];
            double log = doubles[1];

            url += "?lat="+lat+"&log="+log;    //쿼리문

            //http request
            StringBuilder sb = new StringBuilder();
            URL url;
            HttpURLConnection con= null;
            try{
                url = new URL(this.url);
                con = (HttpURLConnection) url.openConnection();

                if(con!=null){
                    con.setConnectTimeout(5000);   //connection 5초이상 길어지면 exepction
                    //con.setReadTimeout(10000);
                    con.setRequestMethod("GET");
                    con.setRequestProperty("Accept","*/*");
                    if(con.getResponseCode()!=HttpURLConnection.HTTP_OK)
                        return null;
                }

            }catch(Exception e){
                return e.getMessage();

            }finally {
                con.disconnect();
            }

            return "";
        }  //doInBackground

    } //LocationTask


    class LoginTask extends AsyncTask<String,Void,String> {

        String url;

        LoginTask() {
        }

        LoginTask(String url) {
            this.url = url;
        }


        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Login");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            String id = strings[0];
            String pwd = strings[1];
            url += "?id="+id+"&pwd="+pwd;    //쿼리문

            //http request
            StringBuilder sb = new StringBuilder();
            URL url;
            HttpURLConnection con= null;
            BufferedReader reader = null;

            try{
                url = new URL(this.url);
                con = (HttpURLConnection) url.openConnection();

                if(con!=null){
                    con.setConnectTimeout(5000);   //connection 5초이상 길어지면 exepction
                    //con.setReadTimeout(10000);
                    con.setRequestMethod("GET");
                    con.setRequestProperty("Accept","*/*");
                    if(con.getResponseCode()!=HttpURLConnection.HTTP_OK)
                        return null;



                    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line = null;
                    while(true){
                        line = reader.readLine();
                        if(line == null){
                            break;
                        }
                        sb.append(line);
                    }


                }



            }catch(Exception e){
                progressDialog.dismiss();
                return e.getMessage();   //리턴하면 post로

            }finally {

                try {
                    if (reader !=null){
                        reader.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                con.disconnect();
            }


            return sb.toString();

        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            if (s.trim().equals("1")){
                Toast.makeText(MainActivity.this,"login ok"+s,Toast.LENGTH_SHORT).show();

            }else if (s.trim().equals("2")){
                Toast.makeText(MainActivity.this,"login fail"+s,Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(MainActivity.this,""+s,Toast.LENGTH_SHORT).show();

            }
        }

    } //LocationTask





    @Override
    public void onBackPressed() {
        super.onBackPressed();
        alBuilder.setTitle("Alert");
        alBuilder.setMessage("Finish");
        alBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                flag = false;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });

        alBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });

        alBuilder.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


