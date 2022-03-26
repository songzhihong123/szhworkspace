package com.song.simple;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhihong Song on 2021/1/5 21:24
 */

public class _1672 {

    public static void main(String[] args) {
    }

    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(s -> Arrays.stream(s).reduce(0,Integer::sum)).max(Comparator.comparingInt(i -> i)).get();
    }

}
