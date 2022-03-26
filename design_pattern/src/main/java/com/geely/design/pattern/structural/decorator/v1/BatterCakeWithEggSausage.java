package com.geely.design.pattern.structural.decorator.v1;

/**
 * Created by Zhihong Song on 2020/11/13 9:45
 */

public class BatterCakeWithEggSausage extends BatterCakeWithEgg{

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
