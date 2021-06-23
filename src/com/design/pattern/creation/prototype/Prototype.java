package com.design.pattern.creation.prototype;

/**
 * Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 * 可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，
 * 简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 *
 * 原型模式的角色：
 * 1.Prototype:抽象原型类
 * 2.ConcretePrototype:具体原型类
 * 3.client 客户端类
 *
 * extension：
 * prototype Manager
 * 原型管理器将多个原型对象存储在一个集合中供客户端使用，他是一个专门负责克隆对象的工厂；
 * 定义了一个集合用于存储原型对象，如需要某个原型对象的一个克隆，可通过复制集合中其他对应的原型对象获得；
 *
 */
public abstract class Prototype{
    public abstract Prototype clone();
}

class ConcretePrototype extends Prototype{

    private String attr;

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return attr;
    }

    @Override
    public Prototype clone() {
        ConcretePrototype prototype=new ConcretePrototype();
        prototype.setAttr(attr);
        return prototype;
    }
}

