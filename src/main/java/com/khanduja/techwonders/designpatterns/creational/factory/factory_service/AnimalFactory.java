package com.khanduja.techwonders.designpatterns.creational.factory.factory_service;

import com.khanduja.techwonders.designpatterns.creational.factory.models.Animal;
import com.khanduja.techwonders.designpatterns.creational.factory.models.animals.Cat;
import com.khanduja.techwonders.designpatterns.creational.factory.models.animals.Dog;

import java.util.Locale;
import java.util.Objects;

public abstract class AnimalFactory {
    public static Animal letAnimalSpeak(String name) {
        if (Objects.isNull(name)) {
            return null;
        }
        return switch (name.toLowerCase(Locale.ROOT)) {
            case "cat" -> new Cat();
            case "dog" -> new Dog();
            default -> null;
        };
    }
}
