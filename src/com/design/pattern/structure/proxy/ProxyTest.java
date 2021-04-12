package com.design.pattern.structure.proxy;

import java.lang.reflect.Proxy;


/**
 * 抽象主题 subject
 * 真实主题 real subject
 * 代理 proxy
 */
public class ProxyTest {

    public static void main(String[] args) {
        Proxy proxy=new Proxy();
        proxy.Request();

    }


    interface Subject {
        void Request();
    }

    static class ReaslSubject implements Subject{
        @Override
        public void Request() {
            System.out.println("realsubject request..");
        }
    }

    static class Proxy implements Subject{

        private ReaslSubject reaslSubject;

        @Override
        public void Request() {
            if(reaslSubject==null){
                reaslSubject=new ReaslSubject();
            }
        }

        public void preRequest(){
            System.out.println("pre request...");
        }


        public void postRequest(){
            System.out.println("post request...");
        }
    }
}