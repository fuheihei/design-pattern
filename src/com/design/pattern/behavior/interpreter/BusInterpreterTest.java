package com.design.pattern.behavior.interpreter;

import java.util.HashSet;
import java.util.Set;

public class BusInterpreterTest {

    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }

    interface AbsExpression {
        boolean interpret(String info);
    }

    static class TerminalExpression implements AbsExpression{
        private Set<String> set = new HashSet<String>();

        public TerminalExpression(String[] data) {
            for (String s : data) set.add(s);
        }

        @Override
        public boolean interpret(String info) {
            return set.contains(info);
        }
    }

    static class AndExpression implements AbsExpression {
        private AbsExpression city = null;
        private AbsExpression person = null;

        public AndExpression(AbsExpression city, AbsExpression person) {
            this.city = city;
            this.person = person;
        }
        @Override
        public boolean interpret(String info) {
            String s[]=info.split("的");
            return city.interpret(s[0])&&person.interpret(s[1]);
        }
    }

    static class Context{
        private AbsExpression cityPerson;
        private String[] citys = {"韶关", "广州"};
        private String[] persons = {"老人", "妇女", "儿童"};

        public Context() {
            AbsExpression city = new TerminalExpression(citys);
            AbsExpression person = new TerminalExpression(persons);
            cityPerson = new AndExpression(city, person);
        }

        public void freeRide(String info) {
            boolean ok = cityPerson.interpret(info);
            if (ok) {
                System.out.println("您是" + info + "，您本次乘车免费！");
            } else {
                System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
            }
        }
    }
}
