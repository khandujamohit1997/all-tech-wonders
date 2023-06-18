package com.khanduja.techwonders.designpatterns.creational.factory.controller;

import com.khanduja.techwonders.designpatterns.creational.factory.models.Animal;
import com.khanduja.techwonders.designpatterns.creational.factory.factory_service.AnimalFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/factory")
public class FactoryController {

    @GetMapping
    public void speak(@RequestParam("animal") @NotBlank @Valid String animal) {
        Animal animalFactory = AnimalFactory.letAnimalSpeak(animal);
        assert animalFactory != null;
        animalFactory.speak();
    }
}
