package com.geely.design.pattern.creational.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhihong Song on 2020/11/5 19:09
 */

public class ContainerSingleton {

    private static Map<String,Object> singletonMap = new HashMap<>();

    private ContainerSingleton(){

    }

    public static void putInstance(String key,Object instance){
        if(StringUtils.isNotBlank(key) && instance != null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }



}
