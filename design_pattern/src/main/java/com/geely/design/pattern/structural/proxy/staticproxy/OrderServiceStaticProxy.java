package com.geely.design.pattern.structural.proxy.staticproxy;

import com.geely.design.pattern.structural.proxy.IOrderService;
import com.geely.design.pattern.structural.proxy.Order;
import com.geely.design.pattern.structural.proxy.OrderServiceImpl;
import com.geely.design.pattern.structural.proxy.db.DataSourceContextHolder;

/**
 * Created by Zhihong Song on 2020/12/22 16:54
 */

public class OrderServiceStaticProxy {

    private IOrderService iOrderService;

    public int saveOrder(Order order){
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    private void beforeMethod(Order order){
        System.out.println("静态代理 before code");

        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db:"+dbRouter+"】处理数据");

        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));

    }

    private void afterMethod(){
        System.out.println("静态代理 after code");
    }

}
