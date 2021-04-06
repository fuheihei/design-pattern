package com.design.pattern.creation.factory;


/**
 * 抽象工厂(Abstract Factory Pattern)
 *
 * 又称为Kit模式
 *
 * 对象：
 * 1 抽象产品
 * 2 具体产品
 * 3 抽象工厂
 * 4 具体工厂
 *
 * 一个工厂可以生产多个产品簇
 */
public class AbstractFactory {

    public static void main(String[] args) {

    }

    interface Product1{
        void show();
    }

    interface Product2{
        void show();
    }

    interface AsFactory{
        Product2 newProduct2();
        Product1 newProduct1();
    }



    class ConcreteF1 implements AsFactory{

        @Override
        public Product2 newProduct2() {
            return null;
        }

        @Override
        public Product1 newProduct1() {
            return null;
        }
    }
}