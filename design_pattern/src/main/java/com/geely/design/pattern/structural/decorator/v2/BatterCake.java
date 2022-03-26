package com.geely.design.pattern.structural.decorator.v2;

/**
 * Created by Zhihong Song on 2020/11/13 9:53
 */

public class BatterCake extends ABatterCake {

    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }

}
