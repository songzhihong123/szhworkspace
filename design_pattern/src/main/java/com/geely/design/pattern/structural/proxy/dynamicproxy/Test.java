package com.geely.design.pattern.structural.proxy.dynamicproxy;

import com.geely.design.pattern.structural.proxy.IOrderService;
import com.geely.design.pattern.structural.proxy.Order;
import com.geely.design.pattern.structural.proxy.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2020/12/22 18:02
 *
 */

public class Test {

    public static void main(String[] args) {

        OrderServiceDynamicProxy proxy = new OrderServiceDynamicProxy(new OrderServiceImpl());
        IOrderService bind = (IOrderService)proxy.bind();
        bind.saveOrder(null);


//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        int size = list.size();
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) == 1){
//                list.remove(i);
//            }
//            if(list.get(i) == 3){
//                list.remove(i);
//            }
//        }
//
//        list.stream().forEach(System.out::println);

    }



}
