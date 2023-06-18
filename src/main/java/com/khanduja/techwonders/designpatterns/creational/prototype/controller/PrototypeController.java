package com.khanduja.techwonders.designpatterns.creational.prototype.controller;

import com.khanduja.techwonders.designpatterns.creational.prototype.model.Person;
import com.khanduja.techwonders.designpatterns.creational.prototype.services.PrototypeCopyCloningService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/v1/prototype/")
public class PrototypeController {

    @Autowired
    PrototypeCopyCloningService prototypeCopyCloningService;

    @GetMapping
    public Person getPrototypePerson(@RequestParam("type") @NotBlank @Valid String type) {
        return Objects.equals(type, "copy") ? prototypeCopyCloningService.getCopyPerson() : prototypeCopyCloningService.getClonedPerson();
    }
}
