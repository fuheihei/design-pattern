package com.design.pattern.structure.flyweight.v02;

public abstract class IgoChessman {
    public abstract String getColor();

    public void display(){
        System.out.println("棋子颜色: "+getColor());
    }

    public void display(Coordinates coordinates){
        System.out.println("棋子颜色: "+getColor()+
                ", 坐标为 ("+coordinates.getX()+","+coordinates.getY()+")");
    }
}
