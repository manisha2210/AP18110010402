package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=findViewById(R.id.pass);
        e2=findViewById(R.id.passs);
        e3=findViewById(R.id.username);
        b1=findViewById(R.id.register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=e3.getText().toString();
                String p= e1.getText().toString();
                String p1 = e2.getText().toString();
                if(u.isEmpty() && p.isEmpty() && p1.isEmpty()){
                    Toast.makeText(Register.this, "Enter username & password", Toast.LENGTH_SHORT).show();
                }

                else if(u.isEmpty()){
                    Toast.makeText(Register.this, "Enter username", Toast.LENGTH_SHORT).show();
                }
                else if(p.isEmpty() || p1.isEmpty()){
                    Toast.makeText(Register.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((e1.getText().toString()).equals(e2.getText().toString())) {
                        Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Register.this, "Password mismatch", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}