package com.example.practicante3.wsvehiculoedwin;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.VehiculoViewHolder> {
    private List<Results> items;

    public static class VehiculoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public CardView vehiculoCardView;
        public TextView iDMake;
        public TextView makeName;


        public VehiculoViewHolder(View v) {
            super(v);
            vehiculoCardView=(CardView) v.findViewById(R.id.vehiculo_card);
            iDMake=(TextView) v.findViewById(R.id.id);
            makeName=(TextView) v.findViewById(R.id.name);

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public VehiculoAdapter(List<Results> items) {
        this.items = items;
    }

    public List<Results> getItems() {
        return this.items;
    }

    @Override
    public VehiculoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_vehiculo,viewGroup,false);
        return new VehiculoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VehiculoViewHolder viewHolder, final int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.iDMake.setText((items.get(i).getMake_ID()));
        viewHolder.makeName.setText((items.get(i).getMake_Name()));


    }
}
