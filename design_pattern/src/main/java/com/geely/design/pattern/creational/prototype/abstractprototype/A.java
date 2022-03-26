package com.geely.design.pattern.creational.prototype.abstractprototype;

/**
 * Created by Zhihong Song on 2020/11/12 8:55
 */

public abstract class A implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
