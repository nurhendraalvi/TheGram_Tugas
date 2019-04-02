package com.example.thegram.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thegram.Model.CarsModel;
import com.example.thegram.R;
import com.example.thegram.View.DetailCars;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder>  {
    Context context;
    List<CarsModel> carsModels = new ArrayList<>();
    public CarsAdapter(Context context, List<CarsModel> carsModels) {
        this.context = context; // set context ke global
        this.carsModels = carsModels; // set model ke global
    }
    @NonNull
    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_cars, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tvName_Cars.setText(carsModels.get(i).getCars_name());
        viewHolder.imageCars.setImageResource(carsModels.get(i).getCars_img());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, DetailCars.class);
               intent.putExtra("name", carsModels.get(i).getCars_name());
               intent.putExtra("image", carsModels.get(i).getCars_img());
                context.startActivity(intent);
                Toast.makeText(context, carsModels.get(i).getCars_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return carsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName_Cars;
        ImageView imageCars;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName_Cars = itemView.findViewById(R.id.cars_name);
            imageCars = itemView.findViewById(R.id.cars_thumbnail);
        }
    }
}
