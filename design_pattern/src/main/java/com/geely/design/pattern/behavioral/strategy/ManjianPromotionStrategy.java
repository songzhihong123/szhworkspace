package com.geely.design.pattern.behavioral.strategy;

/**
 * Created by Zhihong Song on 2020/12/24 21:04
 */

public class ManjianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("满减促销，满200减20元!");
    }
}
