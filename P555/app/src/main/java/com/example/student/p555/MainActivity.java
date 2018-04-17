package com.example.student.p555;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2,editText3;
    TextView textView;
    Button button;
    LoginTask loginTask;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView= findViewById(R.id.textView);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Progress.....");
        progressDialog.setCancelable(false);
        button=findViewById(R.id.button);

    }

    public void clickLogin(View v) throws ExecutionException, InterruptedException { //id,pwd를 입력받는다 toString형태로...
        loginTask=new LoginTask();
        String id=editText.getText().toString();
        String pwd=editText2.getText().toString();
        String result="";

        loginTask.execute(id,pwd);
    }

    class LoginTask extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() { //전처리
            progressDialog.show();
            button.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {  //main 스래드가 진행되는 영역
            String id=strings[0];
            String pwd=strings[1];
            String result="";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(id.equals("qq") && pwd.equals("11")){
                result="1";
            }else{
                result="0";
            }

                return result;
            }

            @Override
            protected void onPostExecute(String s) { //후처리
                progressDialog.dismiss();
                button.setEnabled(true);
                if (s.equals("1")){
                    textView.setText("Login OK");
                    AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("ALert");
                    dialog.setMessage("Login okeydokey");
                    dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editText.setText("");
                            editText2.setText("");
                            return;

                        }
                    });
                    AlertDialog alert = dialog.create();
                    alert.show();
                }else {
                    textView.setText("Login Fail");
                    AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("ALert");
                    dialog.setMessage("Login Fail");
                    dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editText.setText("");
                            editText2.setText("");
                            return;

                        }
                    });
                    AlertDialog alert = dialog.create();
                    alert.show();
            }
        }
    }
}
