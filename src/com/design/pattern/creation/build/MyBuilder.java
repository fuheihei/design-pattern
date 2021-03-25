package com.design.pattern.creation.build;


/**
 * 建造者包含如下角色
 *
 * Builder：抽象建造者
 * ConcreteBuilder：具体建造者
 * Director：指挥者
 * Product：产品角色
 */
public class MyBuilder {

    public static void main(String[] args) {
        System.out.println("---------------RUN : builder pattern ------------------");
        AbsBuilder builder = new ConcereteBuidler();
        Director director = new Director(builder);
        Product product = director.contruct();
        product.show();
    }

    static class Product{
        private String partA;
        private String partB;
        private String partC;

        public void setPartA(String partA) {
            this.partA = partA;
        }

        public void setPartB(String partB) {
            this.partB = partB;
        }

        public void setPartC(String partC) {
            this.partC = partC;
        }

        public void show(){
            System.out.println("A="+partA+",B="+partB+",C="+partC);
        }
    }

    public static abstract class AbsBuilder{
        //创建产品对象
        protected Product product=new Product();

        public abstract void buildPartA();
        public abstract void buildPartB();
        public abstract void buildPartC();

        public Product getResult(){
            return product;
        }
    }

    public static class ConcereteBuidler extends AbsBuilder{

        @Override
        public void buildPartA() {
            product.setPartA("");
        }

        @Override
        public void buildPartB() {
            product.setPartB("");
        }

        @Override
        public void buildPartC() {
            product.setPartC("");
        }
    }

    static class Director{
        private AbsBuilder builder;

        public Director(AbsBuilder builder){
            this.builder=builder;
        }

        public Product contruct(){
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            return builder.getResult();
        }
    }

}