package com.design.pattern.structure.composite;

/**
 * 组合模式
 * composite pattern （aka 整体部分模式 whole-part pattern）
 *
 *
 * 组合模式的角色
 * 1.Component
 * 抽象构件
 * 它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。
 * 在透明式的组合模式中抽象构件还声明访问和管理子类的接口；
 * 在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成。
 * （总的抽象类或接口，定义一些通用的方法，比如新增、删除）
 *
 * 2.Leaf
 * 树叶构件
 * 是组合中的叶节点对象，它没有子节点，用于继承或实现抽象构件。
 *
 * 3. Composite
 * 树枝构件/中间构件：
 * 是组合中的分支节点对象，它有子节点，用于继承和实现抽象构件。
 * 它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。
 *
 * 组合模式分为透明的组合模式和安全式的组合模式
 *
 */
public class CompositeTest {

    public static void main(String[] args) {

    }

}