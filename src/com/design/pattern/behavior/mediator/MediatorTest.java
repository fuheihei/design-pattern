package com.design.pattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介模式
 * mediator pattern
 *
 * 其主要优点如下。
 * 类之间各司其职，符合迪米特法则。
 * 降低了对象之间的耦合性，使得对象易于独立地被复用。
 * 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 *
 * 抽象中介者（Mediator）角色：
 * 它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * 具体中介者（Concrete Mediator）角色：
 * 实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * 抽象同事类（Colleague）角色：
 * 定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * 具体同事类（Concrete Colleague）角色：
 * 是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 *
 *
 */
public class MediatorTest {

    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("------------------");
        c2.send();
    }


    static abstract class Mediator{
        protected List<Colleague> colleagues = new ArrayList<>();
        public void register(Colleague cl){
            if (!colleagues.contains(cl)) {
                colleagues.add(cl);
            }
        }
        public abstract void relay(Colleague cl);
    }

     static class ConcreteMediator extends Mediator{
         @Override
         public void relay(Colleague cl) {
             for (Colleague colleague : colleagues) {
                 if (!colleague.equals(cl)) {
                     ((Colleague) colleague).receive();
                 }
             }
         }
     }


    static abstract class Colleague{
        protected Mediator mediator;
        public void setMedium(Mediator mediator){
            this.mediator=mediator;
        }
        public abstract void receive();
        public abstract void send();
    }

    static class ConcreteColleague1 extends Colleague{
        @Override
        public void receive() {
            System.out.println("具体同事类1收到请求。");
        }
        @Override
        public void send() {
            System.out.println("具体同事类1发出请求。");
            mediator.relay(this);
        }
    }

    static class ConcreteColleague2 extends Colleague{
        @Override
        public void receive() {
            System.out.println("具体同事类2收到请求。");
        }
        @Override
        public void send() {
            System.out.println("具体同事类2发出请求。");
            mediator.relay(this);
        }
    }
}
