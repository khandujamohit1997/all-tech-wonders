package com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.mac;

import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("Mac Checkbox checked");
    }
}
