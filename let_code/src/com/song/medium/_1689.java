package com.song.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/1/20 17:08
 */

public class _1689 {



    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(res,n.charAt(i)-'0');
        }
        return res;
    }

    public int minPartitions1(String n) {
        int res = 0;
        String[] split = n.split("");
        List<String> collect = Arrays.stream(split).sorted().collect(Collectors.toList());
        return Integer.parseInt(collect.get(collect.size() - 1));
    }



    public static void main(String[] args) {
        _1689 obj = new _1689();
        String  n = "27346209830709182346";
        System.out.println(obj.minPartitions1(n));
    }

}
