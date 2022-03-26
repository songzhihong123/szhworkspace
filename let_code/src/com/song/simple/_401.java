package com.song.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-21 09:15
 **/
public class _401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    result.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        _401 obj = new _401();
        int turnedOn = 1;
        obj.readBinaryWatch(turnedOn).forEach(System.out::println);
    }


}
