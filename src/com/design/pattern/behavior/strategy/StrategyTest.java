package com.design.pattern.behavior.strategy;


/**
 * 当某个功能有多个算法和策略
 * 可以根据环境的不同选择不同的策略
 * 例如数据的排序策略有冒泡排序、选择排序、
 * 插入排序，二叉树排序等
 *
 * 策略模式的定义和特点
 * Strategy pattern 的定义：
 * 该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，
 * 且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，
 * 它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，
 * 并委派给不同的对象对这些算法进行管理。
 *
 * 1.模式的结构
 * (1)抽象策略:Strategy类
 * 定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，
 * 环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 *
 * (2)具体策略 Concrete Strategy类
 * 实现了抽象策略定义的接口，提供了具体的方法实现
 *
 * (3)环境类，持有一个策略类的引用，最终给客户端调用
 */
public class StrategyTest {

    public static void main(String[] args) {
        Context c = new Context();
        Strategy s = new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("----------------");
        s = new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }

    interface Strategy{
        void strategyMethod();
    }

    static class ConcreteStrategyA implements Strategy{
        @Override
        public void strategyMethod() {
            System.out.println("具体策略A的策略方法被访问！");
        }
    }

    static class ConcreteStrategyB implements Strategy{
        @Override
        public void strategyMethod() {
            System.out.println("具体策略B的策略方法被访问!");
        }
    }

    static class Context{
        private Strategy strategy;
        public Strategy getStrategy(){
            return this.strategy;
        }
        public void setStrategy(Strategy strategy){
            this.strategy=strategy;
        }

        public void strategyMethod(){
            strategy.strategyMethod();
        }
    }
}
