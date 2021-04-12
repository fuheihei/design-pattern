package com.design.pattern.creation.prototype;

/**
 * Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 * 可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，
 * 简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 */
public class Prototype implements Cloneable{

    private Prototype(){

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
}
