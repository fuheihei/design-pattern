package com.design.pattern.creation.factory;

/**
 *
 * 工厂方法模式也叫
 * 虚拟构造器(Virtual Constructor)模式 或者 多态工厂(Polymorphic Factory)模式
 *
 * 工厂方法模式由
 *  { 抽象工厂，具体工厂，抽象产品，具体产品 }4个要素构成；
 *
 * 一个工厂只有一个产品簇
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Product p;
        AbsFactory af;

        //使用工厂1
        af = new ConcreteFactory1();
        p = af.newProduct();
        p.show();

        //使用工厂2
        af = new ConcreteFactory2();
        p = af.newProduct();
        p.show();
    }



    interface Product{
        void show();
    }

    static class ConcreteProduct1 implements Product{
        @Override
        public void show() {
            System.out.println("Concrete Product 01 show...");
        }
    }

    static class ConcreteProduct2 implements Product{
        @Override
        public void show() {
            System.out.println("Concrete Product 01 show...");
        }
    }

    interface AbsFactory{
        Product newProduct();
    }

    static class ConcreteFactory1 implements AbsFactory{
        @Override
        public Product newProduct() {
            return new ConcreteProduct1();
        }
    }

    static class ConcreteFactory2 implements AbsFactory{
        @Override
        public Product newProduct() {
            return new ConcreteProduct2();
        }
    }
}