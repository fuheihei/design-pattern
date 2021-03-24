package com.designpattern.creation.singleton;

/**
 * 单例模式
 */
public class Singleton <T> {

    private Singleton(){}

    private static volatile Singleton sIntance;

    public static Singleton getInstance(){
        if (sIntance==null){
            synchronized (Singleton.class){
                if(sIntance==null){
                    sIntance=new Singleton();
                }
            }
        }
        return sIntance;
    }
}
