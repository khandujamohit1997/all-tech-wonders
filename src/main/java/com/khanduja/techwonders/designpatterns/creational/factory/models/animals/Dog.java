package com.khanduja.techwonders.designpatterns.creational.factory.models.animals;

import com.khanduja.techwonders.designpatterns.creational.factory.models.Animal;

public class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

