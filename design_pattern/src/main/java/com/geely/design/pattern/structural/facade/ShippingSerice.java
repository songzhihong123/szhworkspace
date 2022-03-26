package com.geely.design.pattern.structural.facade;

/**
 * Created by Zhihong Song on 2020/11/12 19:55
 */

public class ShippingSerice {

    public String shipGift(PointsGift gift){
        //物流系统的对接逻辑
        System.out.println(gift.getName() +  " 进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }

}
