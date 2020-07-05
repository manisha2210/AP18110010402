package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class Second extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String s=getIntent().getStringExtra("n");
        t1=findViewById(R.id.textshow);
        t1.setText("Welcome "+s);
    }
}
