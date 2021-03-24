package com.designpattern.creation.singleton;

/**
 * 饿汉模式
 */
public class HungrySingleton {

    private static final HungrySingleton sIntance = new HungrySingleton();

    private HungrySingleton() {

    }

    public HungrySingleton getInstance() {
        return sIntance;
    }


}
