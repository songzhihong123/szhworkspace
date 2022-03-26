package com.geely.design.pattern.behavioral.strategy;

/**
 * Created by Zhihong Song on 2020/12/24 21:13
 *
 * 策略模式
 */

public class Test {

//    public static void main(String[] args) {
//        PromotionActivity activity = new PromotionActivity(new LijianPromotionStrategy());
//
//        PromotionActivity activity1 = new PromotionActivity(new FanxianPromotionStrategy());
//
//        activity.executePromotionStrategy();
//
//        activity1.executePromotionStrategy();
//    }

    public static void main(String[] args) {
       String promotionKey = "LIJIAN";
       PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
       activity.executePromotionStrategy();
    }

}
