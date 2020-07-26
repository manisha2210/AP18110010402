package com.example.registrationform;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e,e1,e2,e3,e4;
    RadioButton r1,r2;

    String gender;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.roll);
        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.num);
        e3 = findViewById(R.id.mail);
        e4 = findViewById(R.id.pass);
        r1 = findViewById(R.id.male);
        r2 = findViewById(R.id.female);
        sp = findViewById(R.id.Branch);

        ArrayAdapter<CharSequence> group = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_list_item_1);
        sp.setAdapter(group);



    }

    public void submit(View view) {
        String r=e.getText().toString();
        String s=e1.getText().toString();
        String m=e2.getText().toString();
        String e=e3.getText().toString();
        String p1=e4.getText().toString();

        if(r1.isChecked()){
            gender=r1.getText().toString();
        }
        else if(r2.isChecked()){
            gender=r2.getText().toString();
        }

        String course=sp.getSelectedItem().toString();

       if(r.isEmpty() || s.isEmpty() || m.isEmpty() || e.isEmpty() || p1.isEmpty() || (!r1.isChecked() && !r2.isChecked()) || course.isEmpty()){
           Toast.makeText(this, "Please Fill all Details", Toast.LENGTH_SHORT).show();
       }
       else {
           Intent i = new Intent(MainActivity.this, Second.class);
           i.putExtra("roll", r);
           i.putExtra("name", s);
           i.putExtra("phone", m);
           i.putExtra("mail", e);
           i.putExtra("pass", p1);
           i.putExtra("gen", gender);
           i.putExtra("course", course);
           startActivity(i);
       }

    }
}

