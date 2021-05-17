package com.design.pattern.structure.flyweight.v01;

public class IntegerFlyWeightTest {

    public static void main(String[] args) {
        Integer a=126;
        Integer b=200;
        Integer a1=126;
        Integer a2=new Integer(10);
        Integer b1=200;
        System.out.println(a1==a);
        System.out.println(b==b1);
    }
}
