package com.geely.design.pattern.behavioral.strategy;

/**
 * Created by Zhihong Song on 2020/12/24 21:05
 */

public class FanxianPromotionStrategy implements PromotionStrategy{


    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额存放到慕课网用户的余额当中");
    }
}
