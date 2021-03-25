package com.design.pattern.creation.factory;


/**
 * 抽象工厂(Abstract Factory Pattern)
 *
 * 又称为Kit模式
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