package com.play.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest {

    public static void main(String[] args){
//        joinerTest();
//        splitterTest();
        testCharMatch();

    }

    public static void joinerTest(){

        String str = Joiner.on(",").join(Lists.newArrayList("a","b","c"));
        String str1 = Joiner.on("#").join(new String[]{"a","b","c"});
        String str2 = Joiner.on("@").join("first","second",Lists.newArrayList("a","b","c"));

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);

        String str3 = Joiner.on(",").skipNulls().join(Lists.newArrayList("a",null,"c","e",null));
        System.out.println(str3);

        String str4 = Joiner.on(",").useForNull("#").join(Lists.newArrayList("a",null,"c","e",null));
        System.out.println(str4);

        Map<String,String> map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        System.out.println(map);
        String str5 = Joiner.on(",").withKeyValueSeparator(":").join(map);
        System.out.println(str5);

    }

    public static void splitterTest(){
        List<String> list = Splitter.on(",").splitToList("a,b,c,d");
        System.out.println(list);

        Splitter.on(",").split("a,b,c,d").forEach(System.out::println);

        List<String> list1 = Splitter.on(",").omitEmptyStrings().splitToList("a,b,, ,c,d");
        System.out.println("list1:" + list1);  //输出：[a, b,  ,c, d]

        //去掉字符串中的空格，再进行过滤空元素
        List<String> list2 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList("a,b,, ,c,d");
        System.out.println("list2:" + list2); //输出 [a, b, c, d]

        //limit表示最多把字符串分隔成多少份
        List<String> list3 = Splitter.on("#").omitEmptyStrings().trimResults().limit(2).splitToList("a#b#c#d");
        System.out.println("list3:" + list3);


        //将字串还原成map，是Joiner的逆向操作，注意：字符串的格式必须满足“a:1#b:2”这种格式，格式不对会导致还原map失败
        Map<String,String> map = Splitter.on("#").omitEmptyStrings().trimResults().withKeyValueSeparator(":").split("a:1#b:2");
        System.out.println("map:" + map);


    }

    public static void testCharMatch(){
        String s = "er 3j6o  3k  ,)$ wt@ wr4576je  ow3453535345irjew jwfel ";
        String s1 = CharMatcher.inRange('a', 'z').retainFrom(s);
        System.out.println(s1);

        String s2 = CharMatcher.inRange('a', 'z').removeFrom(s);
        System.out.println(s2);

        String str = "aj\tld1\b23aAbCs  kF45JAb  c56sl";
        //移除str中的a
        System.out.println(CharMatcher.is('a').removeFrom(str));
        //移除str中的a
        System.out.println(CharMatcher.isNot('a').retainFrom(str));
        //保留str中的a,b,c字符
        System.out.println(CharMatcher.anyOf("abc").retainFrom(str));


        //保留str中的a,b,c字符
        System.out.println(CharMatcher.noneOf("abc").removeFrom(str));
        //匹配str中的a-j的字母，全部替换成数字6
        System.out.println(CharMatcher.inRange('a', 'j').replaceFrom(str, "6"));
        //去str中的空格
        System.out.println(CharMatcher.breakingWhitespace().removeFrom(str));
        //去掉str中的数字
        System.out.println(CharMatcher.digit().removeFrom(str));
        //去掉控制字符(\t,\n,\b...)
        System.out.println(CharMatcher.javaIsoControl().removeFrom(str));
        //获取str中的小写字母
        System.out.println(CharMatcher.javaLowerCase().retainFrom(str));
        //获取str中的大写字母
        System.out.println(CharMatcher.javaUpperCase().retainFrom(str));

        //组合条件：获取str中的大写字母和数字
        System.out.println(CharMatcher.javaUpperCase().or(CharMatcher.digit()).retainFrom(str));

    }






}
