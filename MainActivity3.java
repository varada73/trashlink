package com.example.trashlink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView name,email,contact,city,details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        contact=findViewById(R.id.cno);
        city=findViewById(R.id.city);
        details=findViewById(R.id.details);
        name.setText(getIntent().getStringExtra("name").toString());
        email.setText(getIntent().getStringExtra("email").toString());
        contact.setText(getIntent().getStringExtra("contact").toString());
        city.setText(getIntent().getStringExtra("city").toString());
        details.setText(getIntent().getStringExtra("details").toString());


    }
}