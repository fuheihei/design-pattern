package com.design.pattern.creation.factory;

/**
 * 简单工厂模式  又叫静态工厂方法模式
 * Simple Factory Patter  aka (Static Factory Method Pattern)
 *
 * 简单工厂模式包含如下角色：
 *
 * Factory：工厂角色
 *   工厂角色负责实现创建所有实例的内部逻辑
 * Product：抽象产品角色
 *   抽象产品角色是所创建的所有对象的父类，负责描述所有实例所共有的公共接口
 * ConcreteProduct：具体产品角色
 *   具体产品角色是创建目标，所有创建的对象都充当这个角色的某个具体类的实例。
 *
 *   特点：没有抽象工厂，只有具体工厂；提供一个统一的工厂创建产品对象
 */
public class SimpleFactory {


    public static void main(String[] args) {
        Factory factory = new Factory();
        Product product = factory.createProduct("HTML");
        product.use();
        product = factory.createProduct("PDF");
        product.use();
    }

    public interface Product {
        void use();
    }

    static class HTMLProduct implements Product {
        @Override
        public void use() {
            System.out.println("HTML product");
        }
    }

    static class PDFProduct implements Product {
        @Override
        public void use() {
            System.out.println("PDF product");
        }
    }

    static class Factory {
        Product createProduct(String name) {
            if ("HTML".equals(name)) {
                return new HTMLProduct();
            } else if ("PDF".equals(name)) {
                return new PDFProduct();
            }
            return null;
        }
    }

}
