package com.design.pattern.structure.decorator;

/**
 * 装饰器类
 *
 * 1. Component 抽象构件：定义一个抽象接口以规范准备接收附加责任的对象
 * 2. ConcreteComponent 具体构件: 实现抽象构件，通过装饰角色为其添加一些职责
 * 3. Decorator 抽象角色: 继承抽象构件，并包含具体构件的实例，
 *    可以通过其子类扩展具体构件的功能
 *
 * 4. ConcreteDecorator 具体装饰角色：
 *    实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class DecoratorTest {


    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }


    interface Component{
        void operation();
    }

    static class ConcreteComponent implements Component {
        public ConcreteComponent() {
        }

        @Override
        public void operation() {
            System.out.println("ConcreteComponent operation");
        }
    }

    static class Decorator implements Component {
        protected Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }

    static class ConcreteDecorator extends Decorator {

        public ConcreteDecorator(Component component) {
            super(component);
        }

        public void operation() {
            super.operation();
            addedFunction();
        }

        //添加的业务方法
        public void addedFunction() {
            System.out.println("ConcreteDecorator operation");
        }
    }
}
