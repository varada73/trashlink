package com.example.trashlink;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{
    ArrayList<model> datalist;


    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).getName());
        holder.t2.setText(datalist.get(position).getCity());
        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(holder.t1.getContext(), MainActivity3.class);
                i.putExtra("name",datalist.get(position).getName());

                i.putExtra("email",datalist.get(position).getEmail());
                i.putExtra("contact",datalist.get(position).getContact());
                i.putExtra("city",datalist.get(position).getCity());
                i.putExtra("details",datalist.get(position).getDetails());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.t1.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class  myviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2;



        public myviewholder(@NonNull View itemView){
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);

        }
    }
}

