package com.design.pattern.behavior.chainofresponsibility;


/**
 * 责任链模式
 *
 * 学习难度 3，使用频率 2
 *
 * ***********************************************************************************************************
 * 模式的结构
 * 抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * 具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，
 * 否则将该请求转给它的后继者。
 * 客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
 * ***********************************************************************************************************
 *
 * 责任链模式降低了请求的发送端和接收端之间的耦合，
 * 使得多个对象都有机会处理这个请求
 *
 * 职责链模式存在以下两种情况。
 * 纯的职责链模式：一个请求必须被某一个处理者对象所接收，且一个具体处理者对某个请求的处理只能采用以下两种行为之一：
 * 自己处理（承担责任）；把责任推给下家处理。
 * 不纯的职责链模式：允许出现某一个具体处理者对象在承担了请求的一部分责任后又将剩余的责任传给下家的情况，
 * 且一个请求可以最终不被任何接收端对象所接收。
 *
 *
 *
 * eg:
 * 1. Netty 中的 Pipeline和ChannelHandler通过责任链设计模式来组织代码逻辑。
 * 2. Spring Security 使用责任链模式，可以动态地添加或删除责任（处理 request 请求）
 */
public class ChainOfResponsibilityTest {

    static abstract class Handler{
        protected Handler successor;

        public void setSuccessor(Handler successor){
            this.successor=successor;
        }

        public Handler getSuccessor(){
            return this.successor;
        }

        public abstract void handleRequest(String request);
    }

    static class ConcreteHandler1 extends Handler {
        @Override
        public void handleRequest(String request) {
            if (request.equals("one")) {

            }else {
                if(getSuccessor()!=null){
                    this.successor.handleRequest(request);
                }else {
                    System.out.println("没有handler处理该请求request");
                }
            }
        }
    }

    static class ConcreteHandler2 extends Handler{
        @Override
        public void handleRequest(String request) {
            if (request.equals("two")) {

            }else {
                if(getSuccessor()!=null){
                    this.successor.handleRequest(request);
                }else {
                    System.out.println("没有handler处理该请求request");
                }
            }
        }
    }


    public static void main(String[] args) {
        Handler handler1=new ConcreteHandler1();
        Handler handler2=new ConcreteHandler2();
        handler1.setSuccessor(handler2);
        handler1.handleRequest("two");
    }
}
