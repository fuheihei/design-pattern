package com.design.pattern.structure.flyweight.v02;

import java.util.Hashtable;

public class IgoChessmanFactory {

    private static IgoChessmanFactory instance=new IgoChessmanFactory();
    private static Hashtable<String,IgoChessman> ht;

    private IgoChessmanFactory(){
        ht=new Hashtable();
        IgoChessman black,white;
        black=new BlackChessman();
        white=new WhiteChessman();
        ht.put("b",black);
        ht.put("w",white);
    }

    public static IgoChessmanFactory getInstance(){
        return instance;
    }

    public static IgoChessman getIgoChessman(String key){
        return ht.get(key);
    }
}
