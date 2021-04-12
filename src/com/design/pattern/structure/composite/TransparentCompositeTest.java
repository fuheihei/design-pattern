package com.design.pattern.structure.composite;


import java.util.ArrayList;

/**
 * transparent composite pattern
 * 透明式的组件模式
 */
public class TransparentCompositeTest {

    public static void main(String[] args) {

    }

    //抽象构件
    interface Component{
        public void add(Component c);
        void remove(Component c);
        Component getChild(int i);
        void operation();
    }
    //树叶构件
    class Leaf implements Component{
        private String name;

        public Leaf(String name){
            this.name=name;
        }
        @Override
        public void add(Component c) {

        }

        @Override
        public void remove(Component c) {

        }

        @Override
        public Component getChild(int i) {
            return null;
        }

        @Override
        public void operation() {
            System.out.println("leaf "+this.name+"is visited !");
        }
    }

    static class Composite implements Component{

        private ArrayList<Component> children=new ArrayList<>();

        @Override
        public void add(Component c) {
            children.add(c);
        }

        @Override
        public void remove(Component c) {
            children.remove(c);
        }

        @Override
        public Component getChild(int i) {
            return children.get(i);
        }

        @Override
        public void operation() {
            for (Component c:children){
                c.operation();
            }
        }
    }
}
