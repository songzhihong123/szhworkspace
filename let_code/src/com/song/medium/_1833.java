package com.song.medium;

import java.util.Arrays;

public class _1833 {


    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if(cost <= coins){
                count ++;
                coins -= cost;
            }else{
                break;
            }
        }
        return count;
    }




    public static void main(String[] args){
        _1833 obj = new _1833();
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(obj.maxIceCream(costs, coins));
    }





}
