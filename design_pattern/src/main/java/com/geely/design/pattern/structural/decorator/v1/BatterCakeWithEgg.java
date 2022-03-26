package com.geely.design.pattern.structural.decorator.v1;

/**
 * Created by Zhihong Song on 2020/11/13 9:43
 */

public class BatterCakeWithEgg extends BatterCake{

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
