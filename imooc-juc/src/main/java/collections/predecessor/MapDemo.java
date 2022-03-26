package collections.predecessor;

import java.util.HashMap;
import java.util.Map;

/**
 * 演示Map的基本用法
 * HashMap 在高并发的环境下会形成环形列表，造成死循环  CPU100%  在JDK7之前存在这个问题
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.isEmpty());
        map.put("1ge",1);
        map.put("2ge",2);
        System.out.println(map.keySet());

    }

}
