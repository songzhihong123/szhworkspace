package com.geely.design.pattern.structural.adapter.objectadapter;


/**
 * Created by Zhihong Song on 2020/11/19 18:12
 */

public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println("ConcreteTarget目标方法");
    }
}
