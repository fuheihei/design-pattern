package com.design.pattern.behavior.interator;


import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 *
 * 迭代器包含以下角色
 *
 * 1. 抽象聚合 aggregate 角色: 定义存储，添加，删除聚合对象以及创建迭代器对象的接口
 * 2. 具体聚合ConcreteAggregate 角色: 实现抽象聚合类，返回具体迭代器的实例
 * 3. 抽象迭代器 Iterator 角色:定义访问和遍历聚合元素的接口，
 *    通常包含hasNext,first,next的方法
 * 4. 具体迭代器 ConcreteIterator
 *    实现抽象迭代器接口中定义的方法
 *    完成对聚合对象的遍历，记录当前遍历的位置
 *
 *
 */
public class IteratorTest {

    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("南京大学");
        ag.add("北京大学");
        System.out.println("聚合的内容有");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.println(ob.toString());
        }
        Object obj = it.first();
        System.out.println("First:" + obj.toString());
    }


    interface Iterator{
        Object first();
        Object next();
        boolean hasNext();
    }

    interface Aggregate{
        void add(Object o);
        void remove(Object o);
        Iterator getIterator();
    }

    static class ConcreteAggregate implements Aggregate{

        private List<Object> list = new ArrayList<>();

        @Override
        public void add(Object o) {
            list.add(o);
        }

        @Override
        public void remove(Object o) {
            list.remove(o);
        }

        @Override
        public Iterator getIterator() {
            return (new ConcreteIterator(list));
        }

    }

    static class ConcreteIterator implements Iterator{

        private List<Object> list;
        private int index=-1;

        public ConcreteIterator(List<Object> list) {
            this.list = list;
        }

        @Override
        public Object first() {
            index = 0;
            Object obj = list.get(index);
            return obj;
        }

        @Override
        public Object next() {
            Object obj = null;
            if (this.hasNext()) {
                obj = list.get(++index);
            }
            return obj;
        }

        @Override
        public boolean hasNext() {
            return index < list.size() - 1;
        }
    }
}
