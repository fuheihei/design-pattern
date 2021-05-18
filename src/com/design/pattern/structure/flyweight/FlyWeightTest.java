package com.design.pattern.structure.flyweight;


import java.util.HashMap;

/**
 * 享元模式
 * 定义: 运用共享技术来有效地支持大量细粒度对象的复用。
 * 它通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率
 *
 * 其主要缺点是：
 * 为了使对象可以共享，需要将一些不能共享的状态外部化，这将增加程序的复杂性。
 * 读取享元模式的外部状态会使得运行时间稍微变长。
 *
 * 享元模式的主要角色:
 * 1. FlyWeight 抽象享元角色
 *   是抽象的享元角色, 他是产品的抽象类, 同时定义出对象的外部状态和内部状态的接口或实现
 * 2. Concrete FlyWeight 具体享元角色
 *   具体的享元角色，是具体的产品类，实现抽象角色定义相关业务
 * 3. Unsharable FlyWeight 非享元角色
 *   是不可共享的角色，一般不会出现在享元工厂。
 * 4. FlyWeight Factory 享元工厂
 *   享元工厂类，用于构建一个池容器(集合)， 同时提供从池中获取对象方法
 *
 * 经典FlyWeight的应用场景：
 * 1. 池技术：池中共享一个连接对象，避免对象的重复创建
 */
public class FlyWeightTest {

    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight f01 = factory.getFlyWeight("a");
        FlyWeight f02 = factory.getFlyWeight("a");
        FlyWeight f03 = factory.getFlyWeight("a");
        FlyWeight f11 = factory.getFlyWeight("b");
        FlyWeight f12 = factory.getFlyWeight("b");
        f01.operation(new UnsharedConcreteFlyWeight("第1次调用a。"));
        f02.operation(new UnsharedConcreteFlyWeight("第2次调用a。"));
        f03.operation(new UnsharedConcreteFlyWeight("第3次调用a。"));
        f11.operation(new UnsharedConcreteFlyWeight("第1次调用b。"));
        f12.operation(new UnsharedConcreteFlyWeight("第2次调用b。"));
    }

    static class UnsharedConcreteFlyWeight{
        private String info;

        UnsharedConcreteFlyWeight(String info){
            this.info=info;
        }

        public String getInfo(){
            return info;
        }

        public void setInfo(String info){
            this.info=info;
        }
    }

    interface FlyWeight {
        void operation(UnsharedConcreteFlyWeight flyWeight);
    }

    static class ConcereFlyWeight implements FlyWeight{
        private String key;

        public ConcereFlyWeight(String key) {
            this.key = key;
        }
        @Override
        public void operation(UnsharedConcreteFlyWeight outState) {
            System.out.print("具体享元" + key + "被调用，");
            System.out.println("非享元信息是:" + outState.getInfo());
        }
    }

    //享元工厂角色
    static class FlyWeightFactory{
        private HashMap<String,FlyWeight> flyWeights=new HashMap<>();

        public FlyWeight getFlyWeight(String key) {
            FlyWeight flyWeight = (FlyWeight) flyWeights.get(key);
            if (flyWeight == null) {
                flyWeight = new ConcereFlyWeight(key);
                flyWeights.put(key, flyWeight);
            } else {
                System.out.println("具体享元" + key + "已经存在，被成功获取");
            }
            return flyWeight;
        }
    }
}
