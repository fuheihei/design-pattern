package com.design.pattern.behavior.command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * command pattern
 * 命令模式
 *
 * 将一个请求封装为一个对象，使得请求的责任和执行请求的责任分隔开
 *
 * 模式的结构：
 * 1. 抽象命令类（Command）角色：
 * 声明执行命令的接口，拥有执行命令的抽象方法 execute()。
 * 2. 具体命令类（Concrete Command）角色：
 * 是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
 * 3. 实现者/接收者（Receiver）角色：
 * 执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 * 4. 调用者/请求者（Invoker）角色：
 * 是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。
 *
 */
public class CommandTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Command cmd=new ConcreteCommand();
        Invoker invoker=new Invoker(cmd);
        System.out.println("client visit invoker's method");
        invoker.call();
    }

    static class Invoker {
        private Command command;

        public Invoker(Command command) {
            this.command = command;
        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public void call() {
            System.out.println("调用者执行命令command ... ");
            this.command.execute();
        }
    }

    interface Command {
        void execute();
    }

    static class ConcreteCommand implements Command {

        private Receiver receiver;

        ConcreteCommand() {
            receiver = new Receiver();
        }

        @Override
        public void execute() {
            receiver.action();
        }
    }

    static class Receiver {
        public void action() {
            System.out.println("接收者 ... action ...");
        }
    }
}
