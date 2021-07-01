package com.design.pattern.structure.facade;


/**
 * 外观模式
 *
 * 1. Facade
 * 外观角色  为多个子系统对外提供一个共同的接口;
 * 2. SubSystem
 * 子系统 实现系统的部分功能，客户可以通过外观角色访问它;
 * 3. Client
 * 客户角色  通过一个外观角色访问各个子系统的功能
 */
public class FacadeTest {

    public static void main(String[] args) {

        Facade facade=new Facade();
        facade.method();
    }

    //外观角色
    static class Facade {
        private SubSytem01 obj1 = new SubSytem01();
        private SubSytem02 obj2 = new SubSytem02();
        private SubSytem03 obj3 = new SubSytem03();

        public void method() {
            obj1.method1();
            obj2.method2();
            obj3.method3();
        }
    }

    static class SubSytem01{
        public void method1(){
            System.out.println("subSystem01");
        }
    }

    static class SubSytem02{
        public void method2(){
            System.out.println("subSystem02");
        }
    }

    static class SubSytem03{
        public void method3(){
            System.out.println("subSystem03");
        }
    }



}
