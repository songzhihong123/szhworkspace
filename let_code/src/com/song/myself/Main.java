package com.song.myself;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/1/25 15:47
 */

public class Main {

    /**
     * 返回最长子串
     */
    public String returnStr(String targetStr){
        int len = targetStr.length();
        List<String> resultList = new ArrayList<>();
        int start = 0;
        for(int i = 0 ; i < len ; i++){
            for (int j = start; j < i; j++) {
                if(targetStr.charAt(i) == targetStr.charAt(j)){
                    resultList.add(targetStr.substring(start,i));
                    start = i;
                    break;
                }
            }
        }
        resultList.add(targetStr.substring(start,len));
        List<String> collect = resultList.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
        return collect.get(collect.size()-1);
    }

    public static void main(String[] args){
        Main obj = new Main();
        String targetStr = "abccbefedc";
        String str = obj.returnStr(targetStr);
        System.out.print(str);
    }


}
