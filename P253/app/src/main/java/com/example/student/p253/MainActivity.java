package com.example.student.p253;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import static com.example.student.p253.R.id.stv2;

public class MainActivity extends AppCompatActivity {
        LinearLayout container;
        LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeui();
    }

    private void makeui() {
        container=findViewById(R.id.container);
        inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //
    }

    public void clickBt(View v){
        inflater.inflate(R.layout.sub,container,true);
        View v1 = inflater.inflate(R.layout.sub, container, true);
        TextView stv = v1.findViewById(R.id.stv);

       // stv.setText("Button click");
        Button sbt1 = v1.findViewById(R.id.sbt1);
        Button sbt2 = v1.findViewById(R.id.sbt2);
        sbt1.setText("Sub Button 1");
        sbt2.setText("Sub Button 2");

        sbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sub2로 변경
                View v1 = inflater.inflate(R.layout.sub, container, true);
                TextView stv = v1.findViewById(R.id.stv2);
            }
        });
        sbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v1 = inflater.inflate(R.layout.sub, container, true);
                TextView stv = v1.findViewById(R.id.stv3);
            }
        });
    }
}
