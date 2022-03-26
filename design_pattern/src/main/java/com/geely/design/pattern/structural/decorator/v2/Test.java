package com.geely.design.pattern.structural.decorator.v2;

/**
 * Created by Zhihong Song on 2020/11/13 10:02
 * 装饰者模式
 */

public class Test {

    public static void main(String[] args) {
        ABatterCake aBatterCake = new BatterCake();
        aBatterCake = new EggDecorator(aBatterCake);
//        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new SausageDecorator(aBatterCake);

        System.out.println(aBatterCake.getDesc() + " 销售价格：" + aBatterCake.cost());

    }
}
