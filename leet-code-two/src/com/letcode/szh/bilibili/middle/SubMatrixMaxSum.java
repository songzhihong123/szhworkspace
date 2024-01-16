package com.letcode.szh.bilibili.middle;

/**
 * @ClassName SubMatrixMaxSum
 * @Description SubMatrixMaxSum
 * @Author szh
 * @Date 2024年01月15日
 */
public class SubMatrixMaxSum {


    /*
        给定一个整形矩阵， 返回子矩阵的最大累计和
     */


    public static int maxSum(int[][] m){
        if(m == null || m.length ==0 || m[0].length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;

        int[] s = null;
        for(int i = 0 ; i < m.length ; i++){
            s = new int[m[0].length];
            for(int j = i ; j < m.length ; j++){
                int cur = 0;
                for(int k = 0 ; k < s.length ; k ++){
                    s[k] += m[j][k];
                    cur += s[k];
                    max= Math.max(max , cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }

        }
        return max;
    }


}
