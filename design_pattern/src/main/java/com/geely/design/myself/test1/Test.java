package com.geely.design.myself.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/1/27 16:31
 */

public class Test {

    /**
     * 两单链表相减
     *
     * a: 4 -> 0 -> 1  (154)
     * b: 1 -> 3  (31)
     *
     *
     *
     * c: 3 -> 2 -> 1 (123)
     *
     *
     * def minus(a, b):
     *
     * print(c)
     */

    public static void main(String[] args) {

        List<Integer> aList = new LinkedList<>();
        List<Integer> bList = new LinkedList<>();
        List<Integer> cList = new LinkedList<>();

        bList.add(4);
        bList.add(5);
        bList.add(1);
        aList.add(1);
        aList.add(3);


        int aLen = aList.size();
        int bLen = bList.size();

        boolean flag = false;

        if(aLen >= bLen){
            for (int i = 0; i < aLen; i++) {
                Integer aValue = aList.get(i);
                if(flag){
                    aValue -= 1;
                    flag = false;
                }
                if(bLen > i){
                    Integer bValue =  bList.get(i);
                    if(aValue >= bValue){
                        cList.add(aValue - bValue);
                    }else{
                        cList.add(10 + aValue - bValue);
                        flag = true;
                    }
                }else{
                    cList.add(aValue);
                }
            }
        }else {
            for (int i = 0; i < bLen; i++) {
                Integer bValue = bList.get(i);
                if(flag){
                    bValue -= 1;
                    flag = false;
                }
                if(aLen > i){
                    Integer aValue =  aList.get(i);
                    if(bValue >= aValue){
                        cList.add(bValue - aValue);
                    }else{
                        cList.add(10 + bValue - aValue);
                        flag = true;
                    }
                }else{
                    cList.add(-bValue);
                }



    }
}

        cList.forEach(System.out::println);




                }



}


