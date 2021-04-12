package com.design.pattern.behavior.tempmethod;


/**
 * 模板方法
 * 定义一个操作中的算法骨架，将算法的一些步骤延迟到子类当中，使得
 * 子类可以不改变算法结构的情况下重定义该算法的某些特定步骤。
 * 它是一种类行为模式
 *
 *
 * 结构：
 * 1.抽象类/抽象模板 Abstract Class
 * 抽象模板类，负责给出一个算法的轮廓和骨架。
 * 它由一个模板方法和若干个基本方法构成。这些方法的定义如下
 * (1) 模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法
 * (2) 基本方法：整个算法的一个步骤
 * (3) 钩子方法：在抽象类中已经实现，
 * 包括用于判断的逻辑方法和需要子类重写的空方法两种。
 *
 * 抽象方法：在抽象类中声明，由具体子类实现
 * 具体方法:
 * 2.具体子类/具体实现 Concrete Class
 */
public class TemplateMethodTest {

    public static void main(String[] args) {

    }
}