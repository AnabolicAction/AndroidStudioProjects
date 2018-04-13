package com.example.student.p300;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Intent intent;
    TextView textView;
    ProgressBar progressBar2;
    ImageView imageView;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView =findViewById(R.id.textView);
        progressBar2= findViewById(R.id.progressBar2);
        imageView =findViewById(R.id.imageView1);
        progressBar2.setMax(100);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);

    }

    //Service로 부터 intent받는다
    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if(intent != null){
            String command = intent.getStringExtra("command");
            int cnt = intent.getIntExtra("cnt", 0);
            textView.setText("----"+cnt);
            progressBar2.setProgress(cnt*10);
            if (cnt%2==0) {
                imageView.setImageResource(R.drawable.bg4);
            }else{
                imageView.setImageResource(R.drawable.bg5);
            }
        }
    }

    public void clickBt(View v) {
        String name = editText.getText().toString();
        intent = new Intent(this, MyService.class);
        intent.putExtra("command", "start");
        intent.putExtra("name", name);
        startService(intent);
    }
    public void clickBt2(View v) {
       progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
       progressDialog.setMessage("진행중");
       progressDialog.show();
       
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(intent != null) {
            stopService(intent);
        }
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("경고");
        builder.setMessage("끝냄?");
        builder.setIcon(R.drawable.dog);
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
             finish();
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;

            }

        });
        builder.show();
    }
}