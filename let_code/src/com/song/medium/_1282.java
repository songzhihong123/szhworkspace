package com.song.medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Zhihong Song on 2021/1/22 13:21
 */

public class _1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> resultList = new ArrayList<>();

        Map<Integer,List<Integer>> tempMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(tempMap.containsKey(groupSizes[i])){
                tempMap.get(groupSizes[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                tempMap.put(groupSizes[i], list);
            }
        }

        for (Integer key : tempMap.keySet()) {
            if(tempMap.get(key).size() <= 3){
                resultList.add(tempMap.get(key));
            }else{
                int size = tempMap.get(key).size();
                int aSize = size / 3;
                int bSize = size % 3;
                if(bSize == 0){
                    for (int i = 0; i < aSize; i++) {
                        resultList.add(new ArrayList<>());
                    }
                }else{
                    for (int i = 0; i < aSize + 1; i++) {
                        resultList.add(new ArrayList<>());
                    }
                }
                List<Integer> integers = tempMap.get(key);
                int size1 = integers.size();
                for (int i = resultList.size() - 1; i >= 0; i--) {
                    for(int j = 0; j < size1;j++){
                        if(j == 3){
                            break;
                        }
                        resultList.get(i).add(integers.get(j));
                        integers.remove(j);
                    }
                }

            }
        }

        return resultList;
    }

    public static void main(String[] args){
        _1282 obj = new _1282();
        int[] groupSizes = {3,3,3,3,3,1,3};
        obj.groupThePeople(groupSizes);
    }

}
