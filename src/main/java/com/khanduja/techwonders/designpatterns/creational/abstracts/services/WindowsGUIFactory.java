package com.khanduja.techwonders.designpatterns.creational.abstracts.services;

import com.khanduja.techwonders.designpatterns.creational.abstracts.abstract_method.GUIFactory;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.Button;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.CheckBox;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.windows.WindowsButton;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.windows.WindowsCheckBox;

public class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
