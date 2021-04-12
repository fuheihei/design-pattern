package com.design.pattern.structure.bridge;


import java.util.Optional;

/**
 * 桥接模式  Bridge pattern
 *
 * 优点是:
 * 1. 抽象与实现分离，扩展能力强;
 * 2. 符合开闭原则
 * 3. 符合合成复用原则
 * 4. 其实现细节对客户透明
 *
 * 结构：
 * 1. 抽象化角色(Abstraction)
 *  定义抽象类，并包含一个对实现化对象的引用。
 * 2. 扩展抽象化角色（Refined Abstraction）
 *  是抽象化角色的子类，实现父类中的业务方法，
 *  并通过组合关系调用实现化角色中的业务方法。
 * 3. 实现化 (Implementor)
 *  定义实现化角色的接口，供扩展抽象化角色调用
 * 4. 具体实现化 (Concrete Implementor)
 *  给出实现化角色接口的具体实现
 */
public class BridgeTest {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.Operation();
    }

    interface Implementor{
        void OperationImpl();
    }

    static class ConcreteImplementA implements Implementor{
        @Override
        public void OperationImpl() {
            System.out.println("Concrete implement 被访问");
        }
    }

    static abstract class Abstraction {
        protected Implementor implementor;
        protected Abstraction(Implementor implementor){
            this.implementor = implementor;
        }

        public abstract void Operation();
    }

    static class RefinedAbstraction extends Abstraction{

        protected RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void Operation() {
            System.out.println("-------Init-------");
            this.implementor.OperationImpl();
        }
    }
}
