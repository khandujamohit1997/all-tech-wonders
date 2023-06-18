package com.khanduja.techwonders.designpatterns.creational.singleton;

public class SingletonLazyInitialization {
    private static volatile SingletonLazyInitialization instance;

    private SingletonLazyInitialization() {

    }

    public SingletonLazyInitialization getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyInitialization.class) {
                if (instance == null) {
                    instance = new SingletonLazyInitialization();
                }
            }
        }
        return instance;
    }
}
