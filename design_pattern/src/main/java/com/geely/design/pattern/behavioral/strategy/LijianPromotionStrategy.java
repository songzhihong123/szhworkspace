package com.geely.design.pattern.behavioral.strategy;

/**
 * Created by Zhihong Song on 2020/12/24 21:04
 */

public class LijianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销，课程的价格直接减去配置的价格");
    }
}
