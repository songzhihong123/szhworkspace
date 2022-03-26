package com.geely.design.pattern.structural.facade;

/**
 * Created by Zhihong Song on 2020/11/12 19:54
 */

public class PointsPaymentService {

    public boolean pay(PointsGift gift){
        //扣减积分
        System.out.println("支付" + gift.getName() +"积分成功！");
        return true;
    }

}
