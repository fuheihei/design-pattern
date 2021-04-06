package com.design.pattern.structure.flyweight.v01;

/**
 * 字符串之间的享元模式
 */
public class FlyWeightTest {


    /**
     * String flyWeight
     */
    public static void main(String[] args) {
        String a="a";
        String a1 = new String("a");
        String a2 = new String("a");
        System.out.println(a == a2);
        System.out.println(a1 == a2);
        System.out.println(a1.intern() == a);
        System.out.println(a1.intern() == a2.intern());
    }
}
