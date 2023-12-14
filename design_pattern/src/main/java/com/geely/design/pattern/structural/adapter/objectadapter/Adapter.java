package com.geely.design.pattern.structural.adapter.objectadapter;

/**
 * Created by Zhihong Song on 2020/11/19 18:17
 * 对象适配器
 *  类适配器 是继承 然后执行父类里面的方法
 *  对象适配器，是new 出来，然后执行对象里面的方法
 *
 */
public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequrst();
    }



}
