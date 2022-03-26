package com.geely.design.pattern.structural.adapter.classadapter;

/**
 * Created by Zhihong Song on 2020/11/19 18:17
 */

public class Adapter extends Adaptee implements Target{

    @Override
    public void request() {
        super.adapteeRequrst();
    }
}
