package com.khanduja.techwonders.designpatterns.creational.abstracts.abstract_method;

import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.Button;
import com.khanduja.techwonders.designpatterns.creational.abstracts.factory_models.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
