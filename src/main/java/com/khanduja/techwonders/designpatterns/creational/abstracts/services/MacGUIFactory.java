package com.khanduja.techwonders.designpatterns.creational.abstracts.services;

import com.khanduja.techwonders.designpatterns.creational.abstracts.abstract_method.GUIFactory;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.Button;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.CheckBox;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.mac.MacButton;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.mac.MacCheckBox;

public class MacGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
