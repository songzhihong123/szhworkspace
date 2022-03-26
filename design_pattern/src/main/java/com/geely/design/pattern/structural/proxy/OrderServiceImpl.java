package com.geely.design.pattern.structural.proxy;

/**
 * Created by Zhihong Song on 2020/12/22 16:40
 */

public class OrderServiceImpl implements IOrderService {

    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        //Spring 会自己注入，我们直接new
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }


}
