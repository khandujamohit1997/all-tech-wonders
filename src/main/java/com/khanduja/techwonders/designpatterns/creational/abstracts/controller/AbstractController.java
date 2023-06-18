package com.khanduja.techwonders.designpatterns.creational.abstracts.controller;

import com.khanduja.techwonders.designpatterns.creational.abstracts.abstract_method.GUIFactory;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.Button;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.CheckBox;
import com.khanduja.techwonders.designpatterns.creational.abstracts.services.MacGUIFactory;
import com.khanduja.techwonders.designpatterns.creational.abstracts.services.WindowsGUIFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/abstract")
public class AbstractController {

    @GetMapping
    public void currentProduct(@RequestParam("os") @NotBlank @Valid String os) {
        GUIFactory factory = switch (os) {
            case "Windows 10" -> new WindowsGUIFactory();
            case "Mac OS" -> new MacGUIFactory();
            default -> throw new UnsupportedOperationException("Unsupported platform");
        };

        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        button.click();
        checkBox.check();
    }
}
