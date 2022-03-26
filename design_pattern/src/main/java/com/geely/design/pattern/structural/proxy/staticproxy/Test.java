package com.geely.design.pattern.structural.proxy.staticproxy;

import com.geely.design.pattern.structural.proxy.Order;

/**
 * Created by Zhihong Song on 2020/12/22 17:27
 *
 * 代理模式
 */

public class Test {


    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
