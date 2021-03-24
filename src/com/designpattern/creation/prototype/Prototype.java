package com.designpattern.creation.prototype;

public class Prototype implements Cloneable{

    private Prototype(){

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
}
