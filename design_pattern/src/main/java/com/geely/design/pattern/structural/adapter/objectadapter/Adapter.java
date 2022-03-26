package com.geely.design.pattern.structural.adapter.objectadapter;

/**
 * Created by Zhihong Song on 2020/11/19 18:24
 */

public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequrst();
    }



}
