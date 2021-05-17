package com.design.pattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * Observer pattern
 * (aka 发布-订阅模式、模型-视图模式)
 *
 * 观察者模式是一种对象行为型模式，其主要优点如下。
 * 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。符合依赖倒置原则。
 * 目标与观察者之间建立了一套触发机制。
 *
 *
 * *********************************************************************************************************
 * 模型的结构
 * 观察者模式的主要角色如下。
 * 抽象主题（Subject）角色：
 * 也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
 * 具体主题（Concrete Subject）角色：
 * 也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 * 抽象观察者（Observer）角色：
 * 它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
 * 具体观察者（Concrete Observer）角色：
 * 实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。
 * *********************************************************************************************************
 *
 *
 */
public class ObserverTest {


    public static void main(String[] args) {

        Subject subject=new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.notifyObserver();
    }

    static class ConcreteObserver1 implements Observer{
        @Override
        public void response() {
            System.out.println("具体观察者1做出反应");
        }
    }
    static class ConcreteObserver2 implements Observer{
        @Override
        public void response() {
            System.out.println("具体观察者2做出反应");
        }
    }

    interface Observer{
        void response();
    }

    static abstract class Subject{
        protected List<Observer> observers=new ArrayList<>();

        public void add(Observer observer){
            observers.add(observer);
        }

        public void remove(Observer observer){
            observers.remove(observer);
        }

        public abstract void notifyObserver();
    }

    static class ConcreteSubject extends Subject{
        @Override
        public void notifyObserver() {
            System.out.println("具体目标发生改变....");
            for (Observer observer : observers) {
                observer.response();
            }
        }
    }

}
