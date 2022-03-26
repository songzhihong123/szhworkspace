package com.geely.design.pattern.structural.facade;

/**
 * Created by Zhihong Song on 2020/11/12 19:44
 *
 *  外观模式
 *
 */

public class T {

    public static void main(String[] args) {
        PointsGift gift = new PointsGift("T恤");

        GiftExchangeService service = new GiftExchangeService();

        service.giftExchange(gift);
    }

}
