package com.geely.design.pattern.structural.adapter.classadapter;

/**
 * Created by Zhihong Song on 2020/11/19 18:17
 *  类适配器
 *  类适配器 是继承 然后执行父类里面的方法
 *  对象适配器，是new 出来，然后执行对象里面的方法
 *
 */
public class Test {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();

    }

}
