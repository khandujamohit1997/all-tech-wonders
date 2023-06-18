package com.khanduja.techwonders.designpatterns.structure.composite.model.impl;

import com.khanduja.techwonders.designpatterns.structure.composite.model.Employee;

// Leaf Class
public class Developer implements Employee {

    private final String name;
    private final String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void displayDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}
