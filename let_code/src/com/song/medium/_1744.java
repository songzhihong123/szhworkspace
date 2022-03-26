package com.song.medium;

import java.util.Arrays;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-01 16:42
 **/
public class _1744 {

    //自己出品 ， 有问题
    public boolean[] canEat(int[] candiesCount, int[][] queries){
        boolean[] result = new boolean[queries.length];
        int canLen = candiesCount.length;
        int[] zone = new int[canLen];
        int zon = 0;
        for (int i = 0; i < canLen; i++) {
            zon += candiesCount[i];
            zone[i] = zon;
        }
        int qLen = queries.length;
        for (int i = 0; i < qLen; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];
            if((favoriteDay + 1 ) * dailyCap < (zone[favoriteType] - candiesCount[favoriteType] + 1)
                    || (favoriteDay + 1) >= zone[favoriteType]) {
                result[i] = false;
                continue;
            }
            result[i] = true;
        }
        return result;
    }

    // 官方出品
    public boolean[] canEat1(int[] candiesCount, int[][] queries){
        int n = candiesCount.length;
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            int favoriteType = query[0];
            int favoriteDay = query[1];
            int dailyCap = query[2];
            long x1 = favoriteDay + 1;
            long y1 = (long)(favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];
            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }



    public static void main(String[] args){
        _1744 obj = new _1744();
        int[] candiesCount = {7,4,5,3,8};
        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};

        boolean[] booleans = obj.canEat1(candiesCount, queries);
        for (boolean boo : booleans){
            System.out.print(boo + " ");
        }
    }


}
