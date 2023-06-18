package com.khanduja.techwonders.mongoDB.model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
