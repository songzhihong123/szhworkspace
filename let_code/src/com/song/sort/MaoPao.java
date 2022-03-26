package com.song.sort;

import java.util.Arrays;

public class MaoPao {


    public static void sort(int[] target){
        int len = target.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i -1; j++) {
                if(target[j] > target[j + 1]){
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
    }

    public static void sort1(int[] target){
        int len = target.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(target[j] > target[j + 1]){
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args){
        int[] target = {5,3,8,4,1};
        sort1(target);
        Arrays.stream(target).forEach(System.out::print);
    }



}
