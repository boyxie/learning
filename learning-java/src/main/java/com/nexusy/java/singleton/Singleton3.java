package com.nexusy.java.singleton;

public class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    //饿汉式
    public static Singleton3 getInstance() {
        return instance;
    }
} 
