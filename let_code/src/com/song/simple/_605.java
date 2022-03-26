package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/7 21:43
 */

public class _605 {

    // 连续3个0就可以种一朵小花
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int conut = 1; // 假设在数组左边添加0，以解决边界问题，令count初始为1
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                conut ++;
            }else{
                conut = 0;
            }
           if(conut == 3){
               res ++;
               conut =1;
           }

        }
        if(conut == 2){
            res ++;
        }
        return  n <= res;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1};
        _605 obj = new _605();
        System.out.println(obj.canPlaceFlowers(flowerbed, 1));
    }

}
