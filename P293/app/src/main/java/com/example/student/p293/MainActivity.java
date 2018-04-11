package com.example.student.p293;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    int cnt=0;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("pref", Activity.MODE_PRIVATE);
    }

    @Override
    protected void onStart() { //시작
        super.onStart();
 //       Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
     //   Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        restoreState();
    }

    @Override
    protected void onPause() {
        super.onPause();
   //     Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        saveState();

    }

    public void restoreState(){
       if(sp !=null){
           if(sp.contains("cnt")){
               int rcnt =sp.getInt("cnt",0);
               Toast.makeText(this, " "+rcnt, Toast.LENGTH_SHORT).show();
           }

       }
    }
    public void saveState(){
        SharedPreferences.Editor editor =sp.edit();
        if(sp !=null) {
            if(sp.contains("cnt")) {
                int rcnt=sp.getInt("cnt",0);
                editor.putInt("cnt", ++rcnt);
                editor.commit();
            }else{
                int cnt=0;
                editor.putInt("cnt", ++cnt);
                editor.commit();
            }
        }
    }

    @Override
    protected void onDestroy() { //뒤질때 호출된다
        super.onDestroy();
    //    Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder =new AlertDialog.Builder(this); //this는 mainacitvity
        builder.setTitle("Alert Message !!");
        builder.setMessage("Are you want to exit & clear");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor editor =sp.edit();
                editor.putInt("cnt", 0);
                editor.commit();
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.show();
    }
}
