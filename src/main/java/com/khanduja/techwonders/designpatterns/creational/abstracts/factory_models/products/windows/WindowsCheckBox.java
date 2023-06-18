package com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.windows;

import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.CheckBox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("Windows Checkbox checked");
    }
}
