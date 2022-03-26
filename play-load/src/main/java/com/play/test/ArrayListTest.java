package com.play.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListTest {


    public static void main(String[] args){

        Integer [] myArray = { 1, 2, 3 };
        List<Integer> myList = Arrays.asList(myArray);

//         myList.add(4); //java.lang.UnsupportedOperationException
        System.out.println(myList.getClass());
        System.out.println("myList: " + myList);


        List list = new ArrayList<>(Arrays.asList(myArray));
        list.add(4);
        System.out.println("list: " + list);

        List<Integer> collect = Arrays.stream(myArray).collect(Collectors.toList());
        collect.add(4);
        System.out.println("collect: " + collect);

        ImmutableList<Integer> integers = ImmutableList.copyOf(myArray);
//        integers.add(4);//java.lang.UnsupportedOperationException
        System.out.println("integers: " + integers);

        List<Integer> list1 = Lists.newArrayList(myArray);
        list1.add(4);
        System.out.println("list1: " + list1);
    }


}
