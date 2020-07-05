package com.example.scores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    TextView t1,t2;
    int a=0,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.three);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.one);
        b4=findViewById(R.id.threesecond);
        b5=findViewById(R.id.twosecond);
        b6=findViewById(R.id.onesecond);
        b7=findViewById(R.id.reset);

        t1=findViewById(R.id.value);
        t2=findViewById(R.id.valuesecond);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a+=3;
                t1.setText(""+a);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a+=2;
                t1.setText(""+a);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a+=1;
                t1.setText(""+a);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b+=3;
                t2.setText(""+b);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b+=2;
                t2.setText(""+b);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b+=1;
                t2.setText(""+b);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("0");
                t2.setText("0");
                a=b=0;
            }
        });


        if(savedInstanceState!=null){
            String s=savedInstanceState.getString("phani");
            String u=savedInstanceState.getString("kiran");
            t1.setText(s);
            t2.setText(u);
            a=Integer.parseInt(s);
            b=Integer.parseInt(u);
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("phani",t1.getText().toString());
        outState.putString("kiran",t2.getText().toString());
    }
}