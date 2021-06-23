package com.design.pattern.creation.singleton;

public class StaticInnerSingleton {

    private StaticInnerSingleton() { }

    public StaticInnerSingleton getInstance() {
        return InnnerSingleton.sIntance;
    }

    public static class InnnerSingleton {
        private static final StaticInnerSingleton sIntance = new StaticInnerSingleton();
    }

}
