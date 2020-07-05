package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et,et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.username);
        et1 = findViewById(R.id.password);

    }

    public void submit(View view) {
        String s= et.getText().toString();
        String p = et1.getText().toString();
        if(s.isEmpty() && p.isEmpty()){
            Toast.makeText(this, "Enter username & password", Toast.LENGTH_SHORT).show();
        }

        else if(s.isEmpty()){
            Toast.makeText(this, "Enter any data", Toast.LENGTH_SHORT).show();
        }
        else if(p.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(MainActivity.this, Second.class);
            i.putExtra("n", s);
            startActivity(i);
        }
    }

    public void register(View view) {
        Intent i = new Intent(MainActivity.this, Register.class);
        startActivity(i);
    }
}
