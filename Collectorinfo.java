package com.example.trashlink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Collectorinfo extends AppCompatActivity {
    FirebaseFirestore db;
    EditText name,email,contact,city,detail;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectorinfo);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        contact=findViewById(R.id.contact);
        city=findViewById(R.id.city);
        detail=findViewById(R.id.details);
        btn=findViewById(R.id.submit);
        db=FirebaseFirestore.getInstance();
Intent i= new Intent(Collectorinfo.this, viewdata.class);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        insertData();
        startActivity(i);
        finish();
    }
});

    }
    public void insertData(){
        Map<String,String> items=new HashMap<>();
        items.put("name",name.getText().toString());
        items.put("email",email.getText().toString());
        items.put("contact",contact.getText().toString());
        items.put("city",city.getText().toString());
        items.put("details",detail.getText().toString());
        db.collection("collectors").add(items).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Collectorinfo.this, "Request submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}