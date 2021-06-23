package com.design.pattern.creation.prototype;

import java.util.Hashtable;



class ConcretePrototypeA extends Prototype{
    @Override
    public Prototype clone() {
        return null;
    }
}

class ConcretePrototypeB extends Prototype{
    @Override
    public Prototype clone() {
        return null;
    }
}

public class PrototypeManager {

    private Hashtable prototypeTable=new Hashtable();

    public PrototypeManager(){
        prototypeTable.put("A",new ConcretePrototypeA());
        prototypeTable.put("B",new ConcretePrototypeB());
    }

    public void add(String key,Prototype prototype){
        prototypeTable.put(key,prototype);
    }

    public Prototype get(String key){
        return ((Prototype)prototypeTable.get(key)).clone();
    }
}
