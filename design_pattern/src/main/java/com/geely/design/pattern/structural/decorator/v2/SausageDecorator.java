package com.geely.design.pattern.structural.decorator.v2;

/**
 * Created by Zhihong Song on 2020/11/13 9:58
 */

public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
