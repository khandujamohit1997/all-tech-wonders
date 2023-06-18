package com.khanduja.techwonders.designpatterns.creational.prototype.services;


import com.khanduja.techwonders.designpatterns.creational.prototype.model.Person;
import org.springframework.stereotype.Service;

//Deep Copy
@Service
public class PrototypeCopyCloningService {

    public Person getClonedPerson() {
        Person person1 = new Person("John Doe", 30, "123 Main St");

        Person person2 = person1.clone();

        person2.setAddress("456 Elm St");

        System.out.println(person1);
        System.out.println(person2);
        return person2;
    }

    public Person getCopyPerson() {
        Person person1 = new Person("John Doe", 30, "123 Main St");

        Person person2 = person1.copy();

        person2.setAddress("456 Elm St");

        System.out.println(person1);
        System.out.println(person2);
        return person2;
    }
}
