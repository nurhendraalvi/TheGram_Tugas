package com.example.thegram.Model;

public class CarsModel {
    private String cars_name, detail_cars;
    private int cars_img;

    public CarsModel(String cars_name, int cars_img, String detail_cars) {
        this.cars_name = cars_name;
        this.cars_img = cars_img;
        this.detail_cars = detail_cars;
    }

    public String getCars_name() {
        return cars_name;
    }

    public int getCars_img() {
        return cars_img;
    }

    public String getDetail_cars() { return detail_cars; }

    public void setDetail_cars(String detail_cars) {
        this.detail_cars = detail_cars;
    }
}
