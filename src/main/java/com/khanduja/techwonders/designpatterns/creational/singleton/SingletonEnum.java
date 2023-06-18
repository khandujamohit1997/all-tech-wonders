package com.khanduja.techwonders.designpatterns.creational.singleton;

public enum SingletonEnum {
    INSTANCE("1 Instance | Serialization | Thread safety | Protection against reflection");

    SingletonEnum(String info) {
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}
