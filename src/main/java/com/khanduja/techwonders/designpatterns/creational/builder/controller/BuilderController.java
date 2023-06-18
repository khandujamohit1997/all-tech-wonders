package com.khanduja.techwonders.designpatterns.creational.builder.controller;

import com.khanduja.techwonders.designpatterns.creational.builder.models.Car;
import com.khanduja.techwonders.designpatterns.creational.builder.models.CarBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/builder")
public class BuilderController {

    @GetMapping
    public void buildCar() {
        Car car = new CarBuilder()
            .setBrand("Tata")
            .setModel("Nexon")
            .build();
        System.out.printf(car.toString());
    }
}
