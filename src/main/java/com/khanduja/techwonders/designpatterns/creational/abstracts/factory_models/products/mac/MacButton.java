package com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.mac;

import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.Button;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("Mac Button clicked");
    }
}
