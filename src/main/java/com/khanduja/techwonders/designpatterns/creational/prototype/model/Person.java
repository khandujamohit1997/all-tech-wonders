package com.khanduja.techwonders.designpatterns.creational.prototype.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable, PersonCopyInterface {

    private String name;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            '}';
    }


    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Person cloning not supported", e);
        }
    }

    @Override
    public Person copy() {
        return new Person(this.name, this.age, this.address);
    }
}
