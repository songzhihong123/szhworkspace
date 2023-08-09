package com.song.myself;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/4/7 9:21
 */

public class Test {


    public static void main(String[] args){

        List<Map<String,String>> list1 = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("hello1","123456");
        map.put("hello4","123456");
        list1.add(map);

        List<Map<String,String>> list2 = new ArrayList<>();
        Map<String,String> map2 = new HashMap<>();
        map2.put("hello1","1234567");
        list2.add(map2);

        List<Map<String,String>> list3 = new ArrayList<>();
        Map<String,String> map3 = new HashMap<>();
        map3.put("hello3","123456");
        list3.add(map3);

      /*  Map<String,String> lastMap = new HashMap<>();
        list1.forEach(lastMap::putAll);
        list2.forEach(lastMap::putAll);
        list3.forEach(lastMap::putAll);*/



       /* map.putAll(map2);
        map.putAll(map3);*/


       List<List<Map<String,String>>> list4 = new ArrayList<>();
        list4.add(list1);
        list4.add(list2);
        list4.add(list3);

        Map<String, String> collect = list4.stream().flatMap(li -> li.stream()).flatMap(m -> m.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));


//        List<Map<String, String>> collect = list4.stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println();

        Integer a = Integer.valueOf(2);

        System.out.println(Objects.equals(a , 2));






        Long until = LocalDateTime.now().until(LocalDateTime.of(2023, 6 , 15 , 16 , 48 , 0), ChronoUnit.MINUTES);

        System.out.println(until);


    }





}
