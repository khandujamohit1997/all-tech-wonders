package com.khanduja.techwonders.designpatterns.creational.builder.models;

public class CarBuilder {
    private String brand;
    private String model;
    private int year;
    private int horsepower;

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public CarBuilder setHorsepower(int horsepower) {
        this.horsepower = horsepower;
        return this;
    }

    public Car build() {
        return new Car(brand, model, year, horsepower);
    }
}
