package com.example.twotext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1, t2;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.head);
        t2 = findViewById(R.id.body);
        e = findViewById(R.id.msg);

    }

    public void send(View view) {
        String s = e.getText().toString();
        if (s.isEmpty()) {
            Toast.makeText(this, "Enter any message", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(MainActivity.this, Reply.class);
            i.putExtra("n", s);
            e.setText("");
            startActivityForResult(i,1);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String result = data.getStringExtra("s");
                t2.setText(result);
                t1.setVisibility(View.VISIBLE);
            }
        }
    }
}