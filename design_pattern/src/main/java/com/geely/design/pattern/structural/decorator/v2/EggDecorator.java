package com.geely.design.pattern.structural.decorator.v2;

/**
 * Created by Zhihong Song on 2020/11/13 9:58
 */

public class EggDecorator extends AbstractDecorator{

    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
