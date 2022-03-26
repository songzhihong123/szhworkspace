package com.song.simple;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/26 10:02
 */

public class _1128 {

    // 超出时间限制
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int len = dominoes.length;
        if(len <= 1){
            return res;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) ||
                        (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])){
                    res ++;
                }
            }
        }
        return res;
    }

    public int numEquivDominoPairs1(int[][] dominoes) {
        int res = 0;
        int[] resArr = new int[100];
        for (int[] dominoe : dominoes) {
            int val = dominoe[0] < dominoe[1] ? 10 * dominoe[0] + dominoe[1] : 10 * dominoe[1] + dominoe[0];
            res += resArr[val];
            resArr[val] ++;
        }
        return res;
    }




    public static void main(String[] args){
        _1128 obj = new _1128();
        int[][] dominoes  = {{1,2},{2,1},{1,2},{1,2},{1,2}};
        System.out.println(obj.numEquivDominoPairs1(dominoes));
    }

}
