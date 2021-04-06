package com.design.pattern.structure.composite;


/**
 * transparent composite pattern
 * 透明式的组件模式
 */
public class TransparentCompositeTest {

    public static void main(String[] args) {

    }

    interface Component{
        public void add(Component c);
        void remove(Component c);
        Component getChild(int i);
        void operation();
    }
}
