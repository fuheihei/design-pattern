# 创建型模式 5个

[简单工厂模式](factory/SimpleFactory.java)
静态工厂方法

[工厂方法模式](factory/FactoryMethod.java)

[抽象工厂模式](factory/AbstractFactory.java)

[建造者模式](build/MyBuilder.java)
优化：
1.Director类可以省略；
2.引入钩子方法
通过引入钩子方法，控制对buildPartX的使用，令Director实现产品的精细构建。

[原型模式](prototype/Prototype.java)
原型管理器(prototype Manager):
原型管理器将多个原型对象存储在一个集合中供客户端使用，他是一个专门负责克隆对象的工厂；
定义了一个集合用于存储原型对象，如需要某个原型对象的一个克隆，
可通过复制集合中其他对应的原型对象获得。
 
[单例模式](singleton/singleton.md)
懒汉模式单例 饿汉模式单例
双重检测锁单例 静态内部类单例

