package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String r=getIntent().getStringExtra("roll");
        String n=getIntent().getStringExtra("name");
        String phno=getIntent().getStringExtra("phone");
        String email=getIntent().getStringExtra("mail");
        String pass=getIntent().getStringExtra("pass");
        String gen=getIntent().getStringExtra("gen");
        String branch=getIntent().getStringExtra("course");

        t1=findViewById(R.id.text);
        t1.setText("User Details: \n"+"Rollno:"+r+"\nName:"+n+"\nPhone:"+phno+"\nEmailid:"+email+"\nPassword:"+pass+"\nGender:"+gen+"\nBranch:"+branch);
    }
}