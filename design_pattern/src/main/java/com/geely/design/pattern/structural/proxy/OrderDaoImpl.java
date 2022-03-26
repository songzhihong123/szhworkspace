package com.geely.design.pattern.structural.proxy;

/**
 * Created by Zhihong Song on 2020/12/22 16:34
 */

public class OrderDaoImpl implements IOrderDao {


    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }



}
