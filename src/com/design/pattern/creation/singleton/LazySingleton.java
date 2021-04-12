package com.design.pattern.creation.singleton;

/**
 * 懒汉模式
 */
public class LazySingleton {

    //保证instance在所有线程中同步
    private static volatile LazySingleton sIntance = null;

    private LazySingleton() {

    }

    /**
     * getInstance 方法前加同步
     */
    public static synchronized LazySingleton getInstance() {
        if (sIntance == null) {
            sIntance = new LazySingleton();
        }
        return sIntance;
    }
}
