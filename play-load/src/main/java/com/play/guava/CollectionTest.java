package com.play.guava;

import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public class CollectionTest {


    public static void main(String[] args){
//        testCopyOf();
//        testOf();
//        testBuilder();
//        testmultSet();
//        testSortMultiset();
//        testmultMap();
        testBiMap();



    }


    public static void testCopyOf(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ImmutableList<String> strings = ImmutableList.copyOf(list);
        list.add("d");
        System.out.println(list);
        System.out.println(strings);
    }


    public static void testOf(){
        ImmutableList<String> of = ImmutableList.of("1", "2", "3");
        System.out.println(of);
    }

    public static void testBuilder(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        ImmutableList<Object> d = ImmutableList.builder().addAll(list).add("d","e").build();
        System.out.println(d);
    }


    //Multiset可以看成是ArrayList和Map的结合体
    public static void testmultSet(){

        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("c");
        multiset.add("c");

        List<String> list = new ArrayList<String>();
        list.add("xx");
        list.add("yy");
        list.add("zz");
        multiset.addAll(list);

        System.out.println(multiset.count("c"));

        Set<String> strings = multiset.elementSet();

        //multiset所有元素的个数
        System.out.println("multiset.size():" + multiset.size());
        //multiset去重后的元素个数
        System.out.println("elementSet().size():" + multiset.elementSet().size());

        //元素迭代
        Iterator<String> it = multiset.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //可以通过设置元素的计数，来批量的添加元素，当然能加也能减
        multiset.setCount("c",5);
        //将元素的计数设为0，就相当于移除所有的"c"元素
        multiset.setCount("c",0);
        //移除一个元素
        multiset.remove("c");
        //移除两个"c"元素
        multiset.remove("c",2);
    }

    public static void  testSortMultiset(){

        SortedMultiset<String> stringSortedMultiset = TreeMultiset.create();
        stringSortedMultiset.setCount("c",5);
        stringSortedMultiset.setCount("a",3);
        stringSortedMultiset.setCount("b",2);

//        Iterator<String> iterator = stringSortedMultiset.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        System.out.println(stringSortedMultiset); // [a x 3, b x 2, c x 5]
        //获取第一个元素
        System.out.println("first: " + stringSortedMultiset.firstEntry().getElement());

        //获取最后一个元素
        System.out.println("last: " + stringSortedMultiset.lastEntry().getElement());

        //获取子集 (a , c] 左开右闭区间
        SortedMultiset<String> subMultiset = stringSortedMultiset.subMultiset("a", BoundType.OPEN,"c",BoundType.CLOSED);

        System.out.println(subMultiset); // [b x 2, c x 5]

    }

    public static void testmultMap(){
        Multimap<String , String> multimap = ArrayListMultimap.create();
        multimap.put("a","123");
        multimap.put("a","111");
        multimap.put("b","456");
        multimap.put("d","789");
        System.out.println("multimap: " + multimap);


        Multimap<String , String> multimap1 = LinkedListMultimap.create();
        multimap1.put("a" , "a1_value");
        multimap1.put("k2","k2_value");

        System.out.println("multimap1: " + multimap1);

        multimap.putAll(multimap1);

        System.out.println("multimap: " + multimap);

        //multimap中的所有键值对，重复的算多个
        System.out.println(multimap.size());

        //key的个数
        System.out.println(multimap.keySet().size());

        //移除指定key的指定value
        multimap.remove("a","111");
        System.out.println("multimap: " + multimap);

        //移除整个key的所有value
        multimap.removeAll("a");
        System.out.println("multimap: " + multimap);

        multimap.replaceValues("b" , Lists.newArrayList("b1_value","b2_value"));
        System.out.println("multimap: " + multimap);

        //是否包含指定的key
        System.out.println(multimap.containsKey("d"));

        //是否包含指定的键值对
        System.out.println(multimap.containsEntry("d","789"));

        //获取multimap中所有的value
        System.out.println(multimap.values());

        //获取multimap中所有的key
        System.out.println(multimap.keys());

        //返回Map类型
        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("map: " + map);

        //清空整个集合
        multimap.clear();

        System.out.println("multimap: " + multimap);

    }

    public static void testBiMap(){
        BiMap<String , String> biMap = HashBiMap.create();
        biMap.put("a","123");
        System.out.println(biMap);

        //对键值对进行反转
        System.out.println(biMap.inverse());

    }




}
