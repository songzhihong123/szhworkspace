package com.geely.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * Created by Zhihong Song on 2020/11/2 19:08
 */

public class HungrySigleton implements Serializable,Cloneable {

    private final static HungrySigleton hungrySigleton ;

    static {
        hungrySigleton= new HungrySigleton();
    }

    private HungrySigleton(){
        if (hungrySigleton != null){
            throw new RuntimeException("单例构造器禁止反射");
        }
    }

    public static HungrySigleton getInstance(){
        return hungrySigleton;
    }

    private Object readResolve(){
        return hungrySigleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
