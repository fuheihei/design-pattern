package com.design.pattern.creation.factory.simplify;

/**
 * 将创建对象的静态方法放到抽象产品中
 *
 */
public abstract class Product {

    public abstract void use();

    public static Product createProduct(String arg){
        switch (arg){
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcreteProductB();
        }
        return null;
    }
}


class ConcreteProductA extends Product{
    @Override
    public void use() {
        System.out.println("ConcreteProductA");
    }
}

class ConcreteProductB extends Product{
    @Override
    public void use() {
        System.out.println("ConcreteProductB");
    }
}

class Client{
    public static void main(String[] args) {
        Product product=Product.createProduct("A");
        product.use();
    }
}
