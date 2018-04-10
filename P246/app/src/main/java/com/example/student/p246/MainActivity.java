package com.example.student.p246;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Resources res;
    ImageView imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();
    }
    public void makeui(){
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
    }
    public void clickBt(View v){
        if(v.getId()==R.id.bt2){
            if(imageView1.getDrawable()!= null){
                imageView2.setImageDrawable(imageView1.getDrawable());
                imageView1.setImageDrawable(null);
            }

        }else if(v.getId()==R.id.bt1){
            if(imageView2.getDrawable()!= null){
                imageView1.setImageDrawable(imageView2.getDrawable());
                imageView2.setImageDrawable(null);
            }

        }

    }
}
