package com.design.pattern.behavior.visitor;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * visitor pattern
 *
 * 访问者模式
 * 将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，
 * 使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，
 * 为数据结构中的每个元素提供多种访问方式。
 * 它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。
 *
 * 1. 抽象访问者 Visitor
 * 定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，
 * 该操作中的参数类型标识了被访问的具体元素。
 *
 * 2. 抽象元素 Element
 * 声明一个接受操作 accept()的接口，
 * 被接受的访问者对象作为 accept() 方法的参数。
 *
 * 3.具体元素 ConcreteElement
 * 实现抽象元素角色提供的 accept()的操作，
 * 其方法体通常都是 visitor.visit(this) ，
 * 另外具体元素中可能还包含本身业务逻辑的相关操作。
 *
 * 4.对象结构 Object structure
 * 是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，
 * 通常由 List、Set、Map 等聚合类实现。
 *
 */
public class VisitorTest {


    public static void main(String[] args) {
        ObjectStructure obs = new ObjectStructure();
        obs.add(new ConcreteElementA());
        obs.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVistorA();
        obs.accept(visitor);
        System.out.println("----------------------------------");
        visitor = new ConcreteVistorB();
        obs.accept(visitor);
    }

    interface Element {
        void accept(Visitor visitor);
    }

    interface Visitor {
        void visit(ConcreteElementA concreteElementA);

        void visit(ConcreteElementB concreteElementB);
    }

    static class ConcreteVistorA implements Visitor{
        @Override
        public void visit(ConcreteElementA concreteElementA) {
            System.out.println("ConcreteVistorA--> "+concreteElementA.operationA());
        }

        @Override
        public void visit(ConcreteElementB concreteElementB) {
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            System.out.println("ConcreteVistorA--> "+concreteElementB.operationB());
        }
    }

    static class ConcreteVistorB implements Visitor{
        @Override
        public void visit(ConcreteElementA concreteElementA) {
            System.out.println("ConcreteVistorB--> "+concreteElementA.operationA());
        }

        @Override
        public void visit(ConcreteElementB concreteElementB) {
            System.out.println("ConcreteVistorB--> "+concreteElementB.operationB());
        }
    }

    static class ConcreteElementA implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public String operationA() {
            return "具体元素A的操作";
        }
    }

    static class ConcreteElementB implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public String operationB() {
            return "具体元素B的操作";
        }
    }

    static class ObjectStructure {
        private List<Element> elements = new ArrayList<>();

        public void accept(Visitor visitor) {
            Iterator<Element> it = elements.iterator();
            while (it.hasNext()) {
                ((Element) it.next()).accept(visitor);
            }
        }

        public void add(Element element) {
            elements.add(element);
        }

        public void remove(Element element) {
            elements.remove(element);
        }
    }
}
