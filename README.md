## 设计模式 Java 代码实现

```java 
设计模式定义：模式是在特定环境下人们解决某类重复出现问题的一套成功或有效的解决方案。

A pattern is a successful or efficient solution to a recurring problem within a context
```

GoF在1994年提出设计模式，有23种设计模式，7个面向对象设计原则
本项目旨在收录各种Java常用的设计模式，组成文档；希望能对你平时的学习和面试工作有所帮助。

## ☕️ 如何开始？
使用Idea，菜单右上角的 File -> open... -> 选择项目打开即可

根据参考的书目，列举了以下的 7个设计原则 和 23种设计模式
## 7个面向对象设计原则
[设计原则详细 doc/design-principle](doc/design-principle.md)

## 23个设计模式

### [创建型模式](src/com/design/pattern/creation/creational-pattern.md)
5个创建型模式

| 模式名称   | 路径                                                         |
| ---------- | ------------------------------------------------------------ |
|1.单例模式   | [creation/Singleton](src/com/design/pattern/creation/singleton/singleton.md) |
|2.建造者模式 | [creation/Builder](src/com/design/pattern/creation/build/MyBuilder.java)  |
|3.抽象工厂模式 | [creation/AbstractFactory](src/com/design/pattern/creation/factory/AbstractFactory.java) |
|4.工厂方法模式 | [creation/FactoryMethod](src/com/design/pattern/creation/factory/FactoryMethod.java) |
|5.简单工厂模式 | [creation/SimpleFactory](src/com/design/pattern/creation/factory/SimpleFactory.java) |
|原型模式| [creation/Prototype](src/com/design/pattern/)

### [行为型模式](src/com/design/pattern/behavior/behavior-pattern.md)
11个行为型模式

| 模式名称   | 路径                                                         |
| ---------- | ------------------------------------------------------------ |
|1.模板方法 |[behavior/Template Method](src/com/design/pattern/behavior/tempmethod/TemplateMethodTest.java)|
|2.策略模式 |[behavior/Strategy](src/com/design/pattern/behavior/strategy/StrategyTest.java)|
|3.责任链模式|[behavior/Chain Of Responsibility](src/com/design/pattern/behavior/chainofresponsibility/ChainOfResponsibilityTest.java)|
|4.命令行模式|[behavior/Command](src/com/design/pattern/behavior/command/CommandTest.java)|
|5.状态模式|[behavior/State](src/com/design/pattern/behavior/state/StateTest.java)|
|6.观察者模式|[behavior/Observer](src/com/design/pattern/behavior/observer/ObserverTest.java)|
|7.中介者模式|[behavior/Mediator](src/com/design/pattern/behavior/mediator/MediatorTest.java)|
|8.迭代器模式|[behavior/Iterator](src/com/design/pattern/behavior/iterator/IteratorTest.java)|
|9.访问者模式|[behavior/Mediator](src/com/design/pattern/behavior/mediator/MediatorTest.java)|
|10.备忘录模式|[behavior/Memento](src/com/design/pattern/behavior/memento/MementoTest.java)|
|11.解释器模式|[behavior/Interpreter](src/com/design/pattern/behavior/interpreter/InterpreterTest.java)|


### [结构型模式](src/com/design/pattern/structure/structure-pattern.md)
7个结构型模式

| 模式名称   | 路径                                                         |
| ---------- | ------------------------------------------------------------ |
|1.代理模式| [structure/Proxy](src/com/design/pattern/structure/proxy/ProxyTest.java)|
|2.适配器模式| [structure/Adapter](src/com/design/pattern/structure/adapter/AdapterTest.java)|
|3.桥接模式 |[structure/Bridge](src/com/design/pattern/structure/bridge/BridgeTest.java)|
|4.装饰器模式 | [structure/Decorator](src/com/design/pattern/structure/decorator/DecoratorTest.java)|
|5.外观模式 | [structure/Facade](src/com/design/pattern/structure/facade/FacadeTest.java)|
|6.享元模式 | [structure/Flyweight](src/com/design/pattern/structure/flyweight/FlyWeightTest.java)|
|7.组合模式  |  [structure/Composite](src/com/design/pattern/structure/composite/CompositeTest.java)|

### Reference
### 📖 参考:
注：无意侵权，如有版权问题，随时删除
1. [《图解设计模式》16种设计模式](https://design-patterns.readthedocs.io/zh_CN/latest/)
2. [Java设计模式：23种设计模式全面解析（超级详细) ](http://c.biancheng.net/design_pattern/)
3. [设计模式(刘伟) 24种设计模式](https://gof.quanke.name/)

### 📧 联系方式:
Email: fuhaixu@foxmail.com <br/>
Slogan: Break knowledge silos
