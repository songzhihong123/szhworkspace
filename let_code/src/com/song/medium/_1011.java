package com.song.medium;/**
 * Created by Zhihong Song on 2021/4/29 17:38
 */

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-29 17:38
 **/
public class _1011 {

    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right){
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            int need = 1;
            // cur为当前这一天已经运送的包裹重量之和
            int cur = 0;
            for(int weight : weights){
                if (cur + weight > mid){
                    need ++;
                    cur = 0;
                }
                cur += weight;
            }
            if(need <= D){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }





    public static void main(String[] args){
        _1011 obj = new _1011();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(obj.shipWithinDays(weights, D));

    }




}
