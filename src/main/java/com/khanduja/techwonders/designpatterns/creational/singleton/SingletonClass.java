package com.khanduja.techwonders.designpatterns.creational.singleton;

public class SingletonClass {
    private static volatile SingletonClass instance;

    private SingletonClass() {

    }

    public SingletonClass getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SingletonClass.class) {
            if (instance == null) {
                instance = new SingletonClass();
            }
        }
        return instance;
    }
}
