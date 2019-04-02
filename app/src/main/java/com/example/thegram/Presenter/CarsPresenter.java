package com.example.thegram.Presenter;

import android.content.Context;

import com.example.thegram.Model.CarsModel;
import com.example.thegram.R;
import com.example.thegram.View.MainView;

import java.util.ArrayList;
import java.util.List;

public class CarsPresenter {
    Context context;
    List<CarsModel> carsModels = new ArrayList<>();
    MainView view;
    public CarsPresenter(MainView view, Context context){
        this.view = view; // set view ke view global
        this.context = context; //set context ke context global
    }
    public void setData(){
        CarsModel cars; //deklarasi sebuah model

        cars= new CarsModel("Nissan SKYLINE R34", R.drawable.skyline,"The Nissan Skyline GT-R is a sports car based on the Nissan Skyline range. The first cars named Skyline GT-R were produced between 1969 and 1972 under the model code KPGC10, and enjoyed legendary success in local Japanese touring car racing.");
        carsModels.add(cars);
        cars = new CarsModel("Nissan GTR R35",R.drawable.gtr,"The Nissan GT-R is a 2-door 2+2 high performance vehicle produced by Nissan, unveiled in 2007. It is the successor to the Nissan Skyline GT-R, although no longer part of the Skyline range itself, that name now being used for Nissan luxury-sport market.");
        carsModels.add(cars);
        cars = new CarsModel("BMW E36",R.drawable.bmw,"The BMW E36 is the third generation of the BMW 3 Series range of compact executive cars, and was produced from October 1990 to 2000. The initial models were of the four-door sedan body style, followed by the coupe, convertible, wagon (Touring) and hatchback (Compact) body styles in later years.");
        carsModels.add(cars);
        cars = new CarsModel("Honda Civic",R.drawable.civic,"The Honda Civic (Japanese: ホンダ・シビック Honda Shibikku) is a line of cars manufactured by Honda. Originally a subcompact, the Civic has gone through several generational changes, becoming both larger and more upmarket and moving into the compact car segment. ");
        carsModels.add(cars);
        cars = new CarsModel("Toyota Fortuner",R.drawable.fortuner,"The Toyota Fortuner (Japanese: トヨタ フォーチュナー Toyota Fōchunā), also known as the Toyota SW4, is a mid-size SUV manufactured by Toyota. Originally assembled only in Thailand and later also in Indonesia and other countries, the Fortuner is built on the Hilux pickup truck platform.");
        carsModels.add(cars);
        cars = new CarsModel("Mitsubishi Lancer Evolution IX",R.drawable.lancer,"The Mitsubishi Lancer Evolution, also known as 'Evo', is a sports sedan based on the Lancer that was manufactured by Japanese manufacturer Mitsubishi Motors from 1992 until 2016 ");
        carsModels.add(cars);
        view.onSucsess(carsModels);
    }
}
