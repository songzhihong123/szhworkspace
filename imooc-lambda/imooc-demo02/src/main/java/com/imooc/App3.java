package com.imooc;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-04 17:41
 **/
public class App3 {

    public static void test(MyInterface<String , List> inter){
        List<String> list = inter.strategy("hello", new ArrayList());
        System.out.println(list);
    }


    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        test((x , y) -> {
            y.add(x);
            return y;
        });

        /*
           (x , y) -> {...} --> param=MyInterface --> lambda表达式 --> MyInterface类型
           这个就是对于lambda表达式的类型检查，MyInterface接口就是表达式的目标类型(target , typing)

           (x , y) -> {...} --> MyInterface.strategy(T t , R r) -> MyInterface<String , List> inter
           --> T==String R==List --> lambda --> (x,y) == strategy(T t , R r) --> x==T==String y==R==List
           lambda 表达式参数的类型检查
         **/

    }


}

@FunctionalInterface
interface MyInterface<T , R>{

    R strategy (T t , R r);

}
