package com.geely.design.pattern.behavioral.strategy;

/**
 * Created by Zhihong Song on 2020/12/24 21:11
 */

public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy(){
        promotionStrategy.doPromotion();
    }

}
