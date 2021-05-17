package com.design.pattern.behavior.memento;

import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 备忘录模式
 * memento pattern
 * 快照模式
 *
 * 备忘录模式的主要角色如下。
 * 发起人（Originator）角色：
 * 记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，
 * 实现其他业务功能，它可以访问备忘录里的所有信息。
 * 备忘录（Memento）角色：
 * 负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 管理者（Caretaker）角色：
 * 对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 *
 */
public class MementoTest {


    public static void main(String[] args) {

        Originator originator=new Originator();
        Caretaker caretaker=new Caretaker();
        originator.setState("S0");
        System.out.println("initial state is"+originator.getState());
        caretaker.setMemento(originator.createMemento());
        originator.setState("S1");
        System.out.println("new state is "+originator.getState());
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("restore state is "+originator.getState());
    }

    static class Memento{
        private String state;

        public Memento(String state){
            this.state=state;
        }

        public void setState(String state){
            this.state=state;
        }

        public String getState(){
            return this.state;
        }
    }

    static class Originator{
        private String state;

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public Memento createMemento(){
            return new Memento(state);
        }

        public void restoreMemento(Memento memento){
            this.setState(memento.getState());
        }
    }

    static class Caretaker {
        private Memento memento;

        public void setMemento(Memento m) {
            this.memento = m;
        }

        public Memento getMemento() {
            return this.memento;
        }
    }

}
