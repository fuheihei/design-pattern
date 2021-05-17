package com.design.pattern.behavior.state;


/**
 * 状态模式 state pattern
 *
 * 定义: 对有状态的对象，把复杂的“判断逻辑”提取到不同的状态对象中，允许状态对象在其内部状态发生改变时改变其行为。
 *
 * 状态模式是一种对象行为型模式，其主要优点如下。
 * 结构清晰，状态模式将与特定状态相关的行为局部化到一个状态中，并且将不同状态的行为分割开来，满足“单一职责原则”。
 * 将状态转换显示化，减少对象间的相互依赖。将不同的状态引入独立的对象中会使得状态转换变得更加明确，且减少对象间的相互依赖。
 * 状态类职责明确，有利于程序的扩展。通过定义新的子类很容易地增加新的状态和转换。
 *
 *
 * 模式的结构：
 * 1. 环境类（Context）角色：
 * 也称为上下文，它定义了客户端需要的接口，内部维护一个当前状态，并负责具体状态的切换。
 * 2. 抽象状态（State）角色：
 * 定义一个接口，用以封装环境对象中的特定状态所对应的行为，可以有一个或多个行为。
 * 3. 具体状态（Concrete State）角色：
 * 实现抽象状态所对应的行为，并且在需要的情况下进行状态切换。
 *
 *
 * eg.
 * 《使用状态模式自由切换登录状态》
 * 《使用状态机实现订单状态流转控制》
 * 《状态模式在JSF源码中的应用》
 */
public class StateTest {

    public static void main(String[] args) {
        Context context=new Context();
        context.Handle();
        context.Handle();
        context.Handle();
        context.Handle();
    }

    static class Context {
        private State state;

        public Context() {
            this.state = new ConcreteStateA();
        }

        public void setState(State state) {
            this.state = state;
        }

        public State getState() {
            return this.state;
        }

        public void Handle(){
            state.Handle(this);
        }
    }

    static abstract class State{
       public abstract void Handle(Context context);
    }

   static class ConcreteStateA extends State{
        @Override
        public void Handle(Context context) {
            System.out.println("current state is A");
            context.setState(new ConcreteStateB());
        }
    }

    static class ConcreteStateB extends State{
        @Override
        public void Handle(Context context) {
            System.out.println("current state is B");
            context.setState(new ConcreteStateA());
        }
    }
}
