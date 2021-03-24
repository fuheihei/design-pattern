package com.designpattern.creation.factory;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

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
 */
public class SimpleFactory {


    public static void main(String[] args) {
        Factory factory = new Factory();
        Product product = factory.createProduct("HTML");
        product.use();

        //JDK example
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            Cipher cp = Cipher.getInstance("DESede");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public interface Product{
        void use();
    }

    static class HTMLProduct implements Product{
        @Override
        public void use() {
            System.out.println("HTML product");
        }
    }
    static class Factory{
        Product createProduct(String name){
            if("HTML".equals(name)){
                return new HTMLProduct();
            }
            return null;
        }
    }

}
