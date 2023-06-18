package com.khanduja.techwonders.designpatterns.creational.builder.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;

    public Car(String brand, String model, int year, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Car{" +
            "brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            ", horsepower=" + horsepower +
            '}';
    }
}
