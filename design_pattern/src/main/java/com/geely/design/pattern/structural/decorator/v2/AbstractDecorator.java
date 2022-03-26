package com.geely.design.pattern.structural.decorator.v2;

/**
 * Created by Zhihong Song on 2020/11/13 9:55
 */

public abstract class AbstractDecorator extends ABatterCake {

    private ABatterCake aBatterCake;

    public AbstractDecorator(ABatterCake aBatterCake){
        this.aBatterCake = aBatterCake;
    }

    protected abstract void doSomething();

    @Override
    protected String getDesc() {
        return this.aBatterCake.getDesc();
    }

    @Override
    protected int cost() {
        return this.aBatterCake.cost();
    }
}
