package com.example.trashlink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class viewdata extends AppCompatActivity {
FirebaseFirestore db;
Button org,s;
EditText se;
ArrayList<model> datalist,search;
myadapter adapater,sadapter;
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        db=FirebaseFirestore.getInstance();
        org=findViewById(R.id.gotoorg);
        s=findViewById(R.id.s);
        se=findViewById(R.id.search);
        datalist=new ArrayList<>();
        search=new ArrayList<>();
        adapater=new myadapter(datalist);
        sadapter=new myadapter(search);
        rv=findViewById(R.id.recview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapater);
        db.collection("collectors").orderBy("name").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot document : queryDocumentSnapshots) {
                    model obj = document.toObject(model.class);
                    datalist.add(obj);
                }
                adapater.notifyDataSetChanged();
            }
        });


se.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        search.clear();
        for (model collector : datalist) {
            if (collector.getName().contains(s.toString())
                    || collector.getEmail().contains(s.toString())
                    || collector.getCity().contains(s.toString())
                    || collector.getDetails().contains(s.toString())) {
                search.add(collector);
            }
        }
        sadapter.notifyDataSetChanged();
        rv.setAdapter(sadapter);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});
s.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        search.clear();
        for (model collector : datalist) {
            if (collector.getName().equals(s.toString())
                    || collector.getEmail().equals(s.toString())
                    || collector.getCity().equals(s.toString())
                    || collector.getDetails().equals(s.toString())) {
                search.add(collector);
            }
        }
        sadapter.notifyDataSetChanged();
        rv.setAdapter(sadapter);
    }
});
org.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(viewdata.this,OrgData.class);
        startActivity(i);
    }
});
    }


}
