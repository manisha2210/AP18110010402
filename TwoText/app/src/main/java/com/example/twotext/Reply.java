package com.example.twotext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Reply extends AppCompatActivity {
    TextView t1;
    EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        e=findViewById(R.id.text);
        t1=findViewById(R.id.show);
        String s=getIntent().getStringExtra("n");
        t1.setText(""+s);
        b=findViewById(R.id.reply);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = e.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(Reply.this, "Enter message", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("s", s);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}