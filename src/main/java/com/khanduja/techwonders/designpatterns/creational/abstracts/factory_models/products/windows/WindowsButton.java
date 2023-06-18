package com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.products.windows;

import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.Button;

public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows Button clicked");
    }
}
