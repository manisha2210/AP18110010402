package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    int myImages[];
    String names1[];
    String version1[];
    String api1[];
    String release1[];
    Context ct;
    public MyAdapter(MainActivity mainActivity, int[] image, String[] names, String[] version, String[] api, String[] release) {
        ct=mainActivity;
        myImages=image;
        names1=names;
        version1=version;
        api1=api;
        release1=release;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.myitem,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(myImages[position]);
        holder.t1.setText(names1[position]);
        holder.t2.setText(version1[position]);
        holder.t3.setText(api1[position]);
        holder.t4.setText(release1[position]);


    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView t1,t2,t3,t4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.img);
            t1=itemView.findViewById(R.id.codename);
            t2=itemView.findViewById(R.id.verno);
            t3=itemView.findViewById(R.id.apilevel);
            t4=itemView.findViewById(R.id.releasedate);


        }
    }
}
