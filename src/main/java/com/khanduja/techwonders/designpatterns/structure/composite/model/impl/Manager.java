package com.khanduja.techwonders.designpatterns.structure.composite.model.impl;

import com.khanduja.techwonders.designpatterns.structure.composite.model.Employee;

import java.util.ArrayList;
import java.util.List;

// Composite Class
public class Manager implements Employee {

    private final String name;
    private final String position;
    private final List<Employee> employees;

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager: " + name + ", Position: " + position);
        System.out.println("Employees under " + name + ":");
        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }
}
