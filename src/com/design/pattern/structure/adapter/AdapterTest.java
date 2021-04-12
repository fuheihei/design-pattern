package com.design.pattern.structure.adapter;


/**
 *
 * 适配器模式（Adapter）包含以下主要角色。
 * 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，
 * 让客户按目标接口的格式访问适配者。
 *
 *
 * 分为两种实现：
 * 类适配器模式，和对象适配器模式
 *
 */
public class AdapterTest {

    public static void main(String[] args) {
        Target target=new ClassAdapter();
        target.request();

        Adaptee adaptee=new Adaptee();
        Target target2=new ObjectAdapter(adaptee);
        target2.request();
    }


    //目标接口
    interface Target{
        void request();
    }

    //适配者接口
    static class Adaptee{
        public void specificRequest(){
            System.out.println("适配者的代码被调用!");
        }
    }

    //类适配器模式
    static class ClassAdapter extends Adaptee implements Target{
        @Override
        public void request() {
            System.out.println("ClassAdapter 开始调用");
            specificRequest();
        }
    }

    //对象适配器模式
    static class ObjectAdapter implements Target{

        private Adaptee adaptee;

        public ObjectAdapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            System.out.println("ObjectAdapter 开始调用");
            this.adaptee.specificRequest();
        }
    }

}
