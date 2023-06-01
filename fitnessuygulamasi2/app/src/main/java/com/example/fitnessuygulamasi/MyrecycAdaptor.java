package com.example.fitnessuygulamasi;

import  android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessuygulamasi.R;
import com.example.fitnessuygulamasi.Yemekler;

import java.util.ArrayList;

public class MyrecycAdaptor extends RecyclerView.Adapter<MyrecycAdaptor.Myholder> {
    ArrayList<Yemekler> yemeklers;

    public MyrecycAdaptor(ArrayList<Yemekler> yemeklers) {
        this.yemeklers = yemeklers;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yemekler_item, parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.tyemekadi.setText( yemeklers.get(position).getYemekadi());
        holder.tkalori.setText(yemeklers.get(position).getKalori());
        holder.ilogo.setImageResource(yemeklers.get(position).getLogo());


    }

    @Override
    public int getItemCount() {
        return yemeklers.size();
    }

    public void tamam(View view) {
    }

    public  class Myholder extends RecyclerView.ViewHolder{
        TextView tyemekadi, tkalori;
        ImageView ilogo;
        Button byedim;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            ilogo = itemView.findViewById(R.id.deimageyemek);
            tyemekadi =itemView.findViewById(R.id.txtyemekadi);
            tkalori = itemView.findViewById(R.id.txtkalori);
            byedim=itemView.findViewById(R.id.btnyedim);


        }
    }
}