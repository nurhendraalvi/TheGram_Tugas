package com.example.thegram.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thegram.R;

public class DetailCars extends AppCompatActivity {
    TextView tvName_Cars;
    ImageView imageCars;
    TextView detailCars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cars);
        tvName_Cars = findViewById(R.id.cars_nama);
        imageCars = findViewById(R.id.cars_thumbnail);
        detailCars = findViewById(R.id.cars_detail);

        String name = getIntent().getStringExtra("name");
        String overview = getIntent().getStringExtra("detail");
        int gambar = getIntent().getIntExtra("image",1);

        tvName_Cars.setText(name);
        imageCars.setImageResource(gambar);
        detailCars.setText(overview);
    }
}
