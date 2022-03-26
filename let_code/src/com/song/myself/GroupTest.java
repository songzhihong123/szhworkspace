package com.song.myself;/**
 * Created by Zhihong Song on 2021/4/19 14:13
 */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-19 14:13
 **/
public class GroupTest {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
//        int counter = 0;
        AtomicInteger counter = new AtomicInteger(0);
        List<Map<String,String>> conentMapList = new ArrayList<>();
        map.keySet().stream().forEach(key -> {
            Map<String,String> temp = new HashMap<>();
            temp.put(key , map.get(key));
            temp.put("counter",String.valueOf(counter.getAndIncrement() / 2));
            conentMapList.add(temp);
        });

        Map<String, List<Map<String, String>>> counter1 = conentMapList.stream().collect(Collectors.groupingBy(mm -> mm.get("counter")));

        System.out.println();


    }

}
