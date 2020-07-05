package com.example.toastcount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    TextView t1;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.increase);
        t1=findViewById(R.id.counttext);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                t1.setText(""+a);
            }
        });
        b2=findViewById(R.id.decrease);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a--;
                t1.setText(""+a);
            }
        });
        b3=findViewById(R.id.resetting);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=0;
                t1.setText(""+a);
            }
        });

        if(savedInstanceState!=null){
            String s=savedInstanceState.getString("phani");
            t1.setText(s);
            a=Integer.parseInt(s);
        }
    }
    public void display(View view){
        Toast.makeText(this, ""+a, LENGTH_SHORT).show();
        // Toast.makeText(this,"Welcome to SRM",Toast.LENGTH_SHORT).show();
        /*
         displays hint messages to user
        context -> if it is activity
                 --- this
                 --- classname.this
                 --- getApplicationContext()
                -> if it is a fragment
                 --- getContext()
                 --- getActivity()
        */

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("phani",t1.getText().toString());
    }
}