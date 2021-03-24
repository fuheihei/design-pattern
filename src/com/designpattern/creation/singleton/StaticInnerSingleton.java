package com.designpattern.creation.singleton;

public class StaticInnerSingleton {

    private StaticInnerSingleton() { }

    public StaticInnerSingleton getIntance() {
        return InnnerSingleton.sIntance;
    }

    public static class InnnerSingleton {
        private static final StaticInnerSingleton sIntance = new StaticInnerSingleton();
    }

}
