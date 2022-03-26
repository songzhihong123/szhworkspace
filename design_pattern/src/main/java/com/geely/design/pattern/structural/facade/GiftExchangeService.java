package com.geely.design.pattern.structural.facade;

/**
 * Created by Zhihong Song on 2020/11/12 20:00
 */

public class GiftExchangeService {

    private final QualifyService qualifyService = new QualifyService();
    private final PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private final ShippingSerice shippingSerice = new ShippingSerice();

    public void giftExchange(PointsGift gift){
        if(qualifyService.isAvailable(gift)){
            //资格校验通过
            if(pointsPaymentService.pay(gift)){
                //积分支付成功
                String orderNo = shippingSerice.shipGift(gift);
                System.out.println("物料系统下单成功，订单号是 : " + orderNo);
            }
        }
    }

}
