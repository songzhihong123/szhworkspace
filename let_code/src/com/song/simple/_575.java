package com.song.simple;

import java.util.*;
import java.util.stream.Stream;

public class _575 {

    public int distributeCandies(int[] candyType) {

        Map<Integer , Integer> countMap = new HashMap<>();
        int len = candyType.length;
        for(int i = 0 ; i < len; i++){
            if(countMap.containsKey(candyType[i])){
                countMap.put(candyType[i] , countMap.get(candyType[i]) + 1);
            }else{
                countMap.put(candyType[i] , 1);
            }
        }

        int countCandy = len / 2;

        int result = 0;

        for (Integer key : countMap.keySet()) {
            if(countMap.get(key) > 0){
                countMap.put(key , countMap.get(key) - 1);
            }else{
                countMap.remove(key);
            }
            if(++result == countCandy){
                break;
            }
        }

        return result;
    }

    public int distributeCandies1(int[] candyType) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < candyType.length; i++) {
            resultList.add(candyType[i]);
        }

        long count = resultList.stream().distinct().count();
        if(count < candyType.length / 2){
            return (int)count;
        }
        return candyType.length / 2;
    }


    public static void main(String[] args){
        _575 obj = new _575();
        int[] candyType = {1,1,1,1,2,2,2,3,3,3};
        System.out.println(obj.distributeCandies1(candyType));
    }


}
