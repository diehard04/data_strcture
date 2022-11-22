package com.example.datastructre.mediakind;

/**
 * Created by Dipak Kumar Mehta on 11/17/2022.
 */
public class Singleton {

    private static Singleton obj = new Singleton();//Early, instance will be created at load time

    private Singleton() {
    }

    public static Singleton getA() {
        return obj;
    }

    public void doSomething() {
        //write your code
    }


    private static Singleton lazyInstanceObj;
    public static Singleton getInstance() {
        if (lazyInstanceObj == null) {
            synchronized (Singleton.class) {
                if (lazyInstanceObj == null) {
                    lazyInstanceObj = new Singleton(); //instance will be created at request time
                }
            }
        }
        return lazyInstanceObj;
    }

}
