package com.letcode.szh.bilibili.middle;

/**
 * @ClassName CordCoverMaxPoint
 * @Description CordCoverMaxPoint
 * @Author szh
 * @Date 2024年01月10日
 */
public class CordCoverMaxPoint {

    /*
    给定一个有序数组arr ， 代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n - 1],
    给定一个正数L ， 代表一根长度为L的绳子， 求绳子最多能覆盖其中的几个点
     */


    public static int maxPoint(int[] arr , int L){
        if(arr.length == 0){
            return 0;
        }

        int left = 0;
        int right = 1;

        int res = 0;
        int length = 0;

        while(left < arr.length){
            if(right >= arr.length){
                res = Math.max(res , (arr.length - 1) - left + 1);
                left ++;
            }else{
                length += (arr[right] - arr[right - 1]);
                if(length == L){
                    res = Math.max(res , right - left + 1);
                    left ++;
                    right = left + 1;
                    length = 0;
                }else if(length > L){
                    res = Math.max(res , (right - 1) - left + 1);
                    left ++;
                    right = left + 1;
                    length = 0;
                }else{
                    right ++;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[] arr = {2 ,4 ,8 ,9 ,12 ,17};
        int L = 8;

        System.out.println(maxPoint(arr , L));




    }











}
