package com.geely.design.pattern.structural.adapter.classadapter;

/**
 * Created by Zhihong Song on 2020/11/19 18:19
 */

public class Test {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();

    }

}
